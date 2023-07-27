package com.setuInterview.AccountOperations.Service.Service.Impl;

import com.setuInterview.AccountOperations.Models.*;
import com.setuInterview.AccountOperations.Models.Enums.AccountType;
import com.setuInterview.AccountOperations.Models.Enums.TransactionType;
import com.setuInterview.AccountOperations.Models.RequestDTO.TransactionDetailRequest;
import com.setuInterview.AccountOperations.Models.ResponseDTO.TransactionResponse;
import com.setuInterview.AccountOperations.Repository.DAOService.DAOService;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;
import com.setuInterview.AccountOperations.Service.Service.WithdrawalService;
import com.setuInterview.AccountOperations.Service.Util.Converter;
import com.setuInterview.AccountOperations.Service.Util.CreateResponses;
import com.setuInterview.AccountOperations.Service.Util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:39
 */

@Service
public class WithdrawalServiceImpl implements WithdrawalService {

    private final DAOService daoService;
    private final Validate validate;
    private final Converter converter;
    private final CreateResponses createResponses;
    private final AccountStrategy accountStrategy;

    @Autowired
    public WithdrawalServiceImpl(DAOService daoService, Validate validate, Converter converter, CreateResponses createResponses, AccountStrategy accountStrategy) {
        this.daoService = daoService;
        this.validate = validate;
        this.converter = converter;
        this.createResponses = createResponses;
        this.accountStrategy = accountStrategy;
    }

    @Override
    public TransactionResponse withdrawAmount(TransactionDetailRequest transactionDetailRequest) {

        AccountDetailDO accountDetailDO = validate.isAccountExist(transactionDetailRequest.getAccountNumber());

        AccountStrategy accountStrategy1 = accountStrategy.getStrategy(AccountType.getAccountEnum(accountDetailDO.getAccountType()));
        validate.validateBehaviours(accountStrategy1, accountDetailDO);
        validate.validateAmountForWithDrawal(accountDetailDO, transactionDetailRequest);

        converter.updateAccountDetailDO(accountDetailDO, transactionDetailRequest, TransactionType.Withdrawal);
        TransactionHistoryDO transactionHistoryDO = createResponses.createTransactionHistoryDO(accountDetailDO,transactionDetailRequest);
        transactionHistoryDO.setTransactionType(TransactionType.Withdrawal.getTransactionName());

        daoService.saveOrUpdate(accountDetailDO);
        daoService.save(transactionHistoryDO);

        TransactionResponse transactionResponse = createResponses.createTransactionResponse(accountDetailDO, transactionHistoryDO);

        return transactionResponse;


    }
}

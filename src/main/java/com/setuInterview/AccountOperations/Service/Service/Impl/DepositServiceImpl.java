package com.setuInterview.AccountOperations.Service.Service.Impl;

import com.setuInterview.AccountOperations.Models.RequestDTO.TransactionDetailRequest;
import com.setuInterview.AccountOperations.Models.ResponseDTO.TransactionResponse;
import com.setuInterview.AccountOperations.Models.Enums.TransactionType;
import com.setuInterview.AccountOperations.Repository.DAOService.DAOService;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;
import com.setuInterview.AccountOperations.Service.Service.DepositService;
import com.setuInterview.AccountOperations.Service.Util.Converter;
import com.setuInterview.AccountOperations.Service.Util.CreateResponses;
import com.setuInterview.AccountOperations.Service.Util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:41
 */

@Service
public class DepositServiceImpl implements DepositService {

    private final DAOService daoService;
    private final Validate validate;
    private final Converter converter;
    private final CreateResponses createResponses;
    @Autowired
    public DepositServiceImpl(DAOService daoService, Validate validate, Converter converter, CreateResponses createResponses) {
        this.daoService = daoService;
        this.validate = validate;
        this.converter = converter;
        this.createResponses = createResponses;
    }

    @Override
    public TransactionResponse depositAmount(TransactionDetailRequest transactionDetailRequest) {
        AccountDetailDO accountDetailDO = validate.isAccountExist(transactionDetailRequest.getAccountNumber());

        converter.updateAccountDetailDO(accountDetailDO, transactionDetailRequest, TransactionType.Deposit);
        TransactionHistoryDO transactionHistoryDO = createResponses.createTransactionHistoryDO(accountDetailDO, transactionDetailRequest);
        transactionHistoryDO.setTransactionType(TransactionType.Deposit.getTransactionName());

        daoService.saveOrUpdate(accountDetailDO);
        daoService.save(transactionHistoryDO);

        TransactionResponse transactionResponse = createResponses.createTransactionResponse(accountDetailDO, transactionHistoryDO);

        return transactionResponse;

    }
}

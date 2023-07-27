package com.setuInterview.AccountOperations.Service.Service.Impl;

import com.setuInterview.AccountOperations.Models.ResponseDTO.UserResponse;
import com.setuInterview.AccountOperations.Repository.DAOService.DAOService;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;
import com.setuInterview.AccountOperations.Repository.Entities.UserDetailDO;
import com.setuInterview.AccountOperations.Service.Service.TransactionHistoryService;
import com.setuInterview.AccountOperations.Service.Util.CreateResponses;
import com.setuInterview.AccountOperations.Service.Util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:41
 */

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    private final DAOService daoService;
    private final Validate validate;
    private final CreateResponses createResponses;

    @Autowired
    public TransactionHistoryServiceImpl(DAOService daoService, Validate validate, CreateResponses createResponses) {
        this.daoService = daoService;
        this.validate = validate;
        this.createResponses = createResponses;
    }
    @Override
    public UserResponse getTransactionHistory(String accountNumber) {

        AccountDetailDO accountDetailDO = validate.isAccountExist(accountNumber);
        UserDetailDO userDetailDO = daoService.getUserDetails(accountNumber);
        List<TransactionHistoryDO> transactionHistoryDOList = daoService.getTransactionsForPast30Days(accountNumber);
        return createResponses.createTransactionHistoryResponse(accountDetailDO, userDetailDO, transactionHistoryDOList);

    }
}

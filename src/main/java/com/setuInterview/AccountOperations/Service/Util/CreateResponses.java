package com.setuInterview.AccountOperations.Service.Util;

import com.setuInterview.AccountOperations.Constants.CustomHTTPCodes;
import com.setuInterview.AccountOperations.Models.Enums.AccountType;
import com.setuInterview.AccountOperations.Models.Enums.TransactionType;
import com.setuInterview.AccountOperations.Models.RequestDTO.TransactionDetailRequest;
import com.setuInterview.AccountOperations.Models.ResponseDTO.HTTPResponse;
import com.setuInterview.AccountOperations.Models.ResponseDTO.TransactionResponse;
import com.setuInterview.AccountOperations.Models.ResponseDTO.UserResponse;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;
import com.setuInterview.AccountOperations.Repository.Entities.UserDetailDO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 07:05
 */

@Service
public class CreateResponses {

    public UserResponse createUserDetailResponse(UserDetailDO userDetailDO, AccountDetailDO accountDetailDO){
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userDetailDO.getId());
        userResponse.setAccountId(accountDetailDO.getId());
        userResponse.setName(userDetailDO.getName());
        userResponse.setMobile(userDetailDO.getMobile());
        userResponse.setAccountNumber(userDetailDO.getAccountNumber());
        userResponse.setAccountType(AccountType.getAccountName(accountDetailDO.getAccountType()));
        userResponse.setCreatedOn(userDetailDO.getCreatedOn());
        userResponse.setHttpResponse(new HTTPResponse(CustomHTTPCodes.AccountCreated.getCode(), CustomHTTPCodes.AccountCreated.getMessage()));
        return userResponse;
    }

    public TransactionHistoryDO createTransactionHistoryDO(AccountDetailDO accountDetailDO, TransactionDetailRequest transactionDetailRequest){
        TransactionHistoryDO transactionHistoryDO = new TransactionHistoryDO();
        transactionHistoryDO.setTransactionBalance(transactionDetailRequest.getBalance());
        transactionHistoryDO.setAccountNumber(accountDetailDO.getAccountNumber());
        transactionHistoryDO.setFinalBalance(accountDetailDO.getBalance());
        transactionHistoryDO.setCreatedOn(LocalDateTime.now());
        return transactionHistoryDO;
    }

    public TransactionResponse createTransactionResponse(AccountDetailDO accountDetailDO,
                                                         TransactionHistoryDO transactionHistoryDO){
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setAccountId(accountDetailDO.getId());
        transactionResponse.setAccountNumber(accountDetailDO.getAccountNumber());
        transactionResponse.setAccountType(AccountType.getAccountName(accountDetailDO.getAccountType()));
        transactionResponse.setFinalBalance(accountDetailDO.getBalance());
        transactionResponse.setTransactionCharge(accountDetailDO.getTransactionCharge());
        if(transactionHistoryDO.getTransactionType().equals(TransactionType.Withdrawal.getTransactionName())){
            transactionResponse.setPreviousBalance(accountDetailDO.getBalance() + transactionHistoryDO.getTransactionBalance() + accountDetailDO.getTransactionCharge());
            transactionResponse.setAmountWithdrawn(transactionHistoryDO.getTransactionBalance());
            transactionResponse.setHttpResponse(new HTTPResponse(CustomHTTPCodes.WithDrawalSuccessful.getCode(), CustomHTTPCodes.WithDrawalSuccessful.getMessage()));
        } else if (transactionHistoryDO.getTransactionType().equals(TransactionType.Deposit.getTransactionName())){
            transactionResponse.setPreviousBalance(accountDetailDO.getBalance() - transactionHistoryDO.getTransactionBalance());
            transactionResponse.setAmountDeposited(transactionHistoryDO.getTransactionBalance());
            transactionResponse.setHttpResponse(new HTTPResponse(CustomHTTPCodes.DepositSuccessful.getCode(), CustomHTTPCodes.DepositSuccessful.getMessage()));
        }
        transactionResponse.setCreatedOn(transactionHistoryDO.getCreatedOn());

        return transactionResponse;
    }

    public UserResponse createTransactionHistoryResponse(AccountDetailDO accountDetailDO, UserDetailDO userDetailDO, List<TransactionHistoryDO> transactionHistoryDOList) {

        UserResponse userResponse = new UserResponse();
        userResponse.setAccountId(accountDetailDO.getId());
        userResponse.setUpdatedOn(accountDetailDO.getUpdatedOn());
        userResponse.setCreatedOn(userDetailDO.getCreatedOn());
        userResponse.setName(userDetailDO.getName());
        userResponse.setMobile(userDetailDO.getMobile());
        userResponse.setUserId(userDetailDO.getId());
        userResponse.setAccountNumber(userDetailDO.getAccountNumber());
        userResponse.setBalance(accountDetailDO.getBalance());
        userResponse.setTransactionHistory(transactionHistoryDOList);
        userResponse.setAccountType(AccountType.getAccountName(accountDetailDO.getAccountType()));
        userResponse.setHttpResponse(new HTTPResponse(CustomHTTPCodes.HistorySent.getCode(), CustomHTTPCodes.HistorySent.getMessage()));

        return userResponse;
    }


}

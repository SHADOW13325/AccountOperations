package com.setuInterview.AccountOperations.Service.Util;

import com.setuInterview.AccountOperations.Models.RequestDTO.TransactionDetailRequest;
import com.setuInterview.AccountOperations.Models.Enums.TransactionType;
import com.setuInterview.AccountOperations.Models.RequestDTO.UserDetailRequest;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.UserDetailDO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 22:15
 */

@Service
public class Converter {

    public UserDetailDO convertUserDetailToUserDetailDO(UserDetailRequest userDetailRequest, String accountNumber){
        UserDetailDO userDetailDO = new UserDetailDO();
        userDetailDO.setName(userDetailRequest.getName());
        userDetailDO.setMobile(userDetailRequest.getMobile());
        userDetailDO.setCreatedOn(LocalDateTime.now());
        userDetailDO.setAccountNumber(accountNumber);
        return userDetailDO;
    }

    public AccountDetailDO updateAccountDetailDO(AccountDetailDO accountDetailDO,
                                TransactionDetailRequest transactionDetailRequest, TransactionType transactionType){
        accountDetailDO.setUpdatedOn(LocalDateTime.now());
        if(transactionType.equals(TransactionType.Withdrawal)){
            accountDetailDO.setBalance(accountDetailDO.getBalance() - transactionDetailRequest.getBalance() - accountDetailDO.getTransactionCharge());
        } else if (transactionType.equals(TransactionType.Deposit)){
            accountDetailDO.setBalance(accountDetailDO.getBalance() + transactionDetailRequest.getBalance());
        }

        return accountDetailDO;
    }
}

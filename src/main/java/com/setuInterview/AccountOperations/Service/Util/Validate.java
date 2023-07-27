package com.setuInterview.AccountOperations.Service.Util;

import com.setuInterview.AccountOperations.Constants.CustomHTTPCodes;
import com.setuInterview.AccountOperations.Exceptions.SetuException;
import com.setuInterview.AccountOperations.Models.AccountStrategy;
import com.setuInterview.AccountOperations.Models.RequestDTO.TransactionDetailRequest;
import com.setuInterview.AccountOperations.Repository.DAOService.DAOService;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 11:28
 */

@Service
public class Validate {

    DAOService daoService;

    @Autowired
    public Validate(DAOService daoService) {
        this.daoService = daoService;
    }

    public void validateBehaviours(AccountStrategy accountStrategy, AccountDetailDO accountDetailDO){

        if(!accountStrategy.getMinBalanceCheck().minBalanceCheck(accountDetailDO))
            throw new SetuException(CustomHTTPCodes.BalanceLessThanMinimum.getMessage(), CustomHTTPCodes.BalanceLessThanMinimum.getCode());
        if(!accountStrategy.getAverageBalanceCheck().averageBalanceCheck(accountDetailDO))
            throw new SetuException(CustomHTTPCodes.AverageBalanceLessThanMinimum.getMessage(), CustomHTTPCodes.AverageBalanceLessThanMinimum.getCode());
        if(!accountStrategy.getBlockTransaction().blockTransaction(accountDetailDO))
            throw new SetuException(CustomHTTPCodes.WithDrawalLimitReached.getMessage(), CustomHTTPCodes.WithDrawalLimitReached.getCode());


    }

    public void validateAmountForWithDrawal(AccountDetailDO accountDetailDO, TransactionDetailRequest transactionDetailRequest){
        if (accountDetailDO.getBalance() < transactionDetailRequest.getBalance())
            throw new SetuException(CustomHTTPCodes.InsufficientBalance.getMessage(), CustomHTTPCodes.InsufficientBalance.getCode());
    }

    public AccountDetailDO isAccountExist(String accountNumber){
        AccountDetailDO accountDetailDO = daoService.getAccount(accountNumber);
        if (accountDetailDO == null){
            throw new SetuException(CustomHTTPCodes.AccountNotFound.getCode(), CustomHTTPCodes.AccountNotFound.getMessage());
        }

        return accountDetailDO;
    }
}

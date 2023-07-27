package com.setuInterview.AccountOperations.Models;

import com.setuInterview.AccountOperations.ApplicationContextProvider;
import com.setuInterview.AccountOperations.Models.Enums.AccountType;
import com.setuInterview.AccountOperations.Service.Behaviours.IAverageBalanceCheck;
import com.setuInterview.AccountOperations.Service.Behaviours.IBlockTransaction;
import com.setuInterview.AccountOperations.Service.Behaviours.IMinBalanceCheck;
import com.setuInterview.AccountOperations.Service.Behaviours.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 10:39
 */

@Component
public class AccountStrategy {

    private IBlockTransaction blockTransaction;
    private IMinBalanceCheck minBalanceCheck;
    private IAverageBalanceCheck averageBalanceCheck;


    private ApplicationContextProvider applicationContextProvider;

    @Autowired
    public AccountStrategy(ApplicationContextProvider applicationContextProvider){
        this.applicationContextProvider = applicationContextProvider;
    }


    private AccountStrategy(IBlockTransaction blockTransaction, IMinBalanceCheck minBalanceCheck,
                            IAverageBalanceCheck averageBalanceCheck){
        this.blockTransaction = blockTransaction;
        this.minBalanceCheck = minBalanceCheck;
        this.averageBalanceCheck = averageBalanceCheck;

    }

    public AccountStrategy getStrategy(AccountType accountType){
        AccountStrategy accountStrategy = switch(accountType){
            case REGULAR -> new AccountStrategy(applicationContextProvider.getApplicationContext().getBean(ChargeOnTransaction.class),
                    applicationContextProvider.getApplicationContext().getBean(MinBalanceNotRequired.class),
                    applicationContextProvider.getApplicationContext().getBean(AverageBalanceRequired.class));
            case STUDENT -> new AccountStrategy(applicationContextProvider.getApplicationContext().getBean(TransactionBlocking.class),
                    applicationContextProvider.getApplicationContext().getBean(MinBalanceRequired.class),
                    applicationContextProvider.getApplicationContext().getBean(AverageBalanceNotRequired.class));
            case ZERO_BALANCE -> new AccountStrategy(applicationContextProvider.getApplicationContext().getBean(TransactionBlocking.class),
                    applicationContextProvider.getApplicationContext().getBean(MinBalanceNotRequired.class),
                    applicationContextProvider.getApplicationContext().getBean(AverageBalanceNotRequired.class));
        };

        return accountStrategy;
    }

    public IBlockTransaction getBlockTransaction() {
        return blockTransaction;
    }

    public IMinBalanceCheck getMinBalanceCheck() {
        return minBalanceCheck;
    }

    public IAverageBalanceCheck getAverageBalanceCheck() {
        return averageBalanceCheck;
    }
}

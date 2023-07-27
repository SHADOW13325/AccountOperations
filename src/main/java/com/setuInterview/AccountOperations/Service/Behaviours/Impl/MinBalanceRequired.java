package com.setuInterview.AccountOperations.Service.Behaviours.Impl;

import com.setuInterview.AccountOperations.Models.Enums.AccountType;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Service.Behaviours.IMinBalanceCheck;
import org.springframework.stereotype.Component;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:59
 */

@Component
public class MinBalanceRequired implements IMinBalanceCheck {
    @Override
    public boolean minBalanceCheck(AccountDetailDO accountDetailDO) {
        AccountType accountType = AccountType.getAccountEnum(accountDetailDO.getAccountType());
        return (accountType.getMinBalance() <= accountDetailDO.getBalance());
    }
}

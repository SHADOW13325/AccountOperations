package com.setuInterview.AccountOperations.Service.Behaviours.Impl;

import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Service.Behaviours.IMinBalanceCheck;
import org.springframework.stereotype.Component;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:58
 */

@Component
public class MinBalanceNotRequired implements IMinBalanceCheck {
    @Override
    public boolean minBalanceCheck(AccountDetailDO accountDetailDO) {
        return true;
    }
}

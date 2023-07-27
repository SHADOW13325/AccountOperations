package com.setuInterview.AccountOperations.Service.Behaviours.Impl;

import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Service.Behaviours.IAverageBalanceCheck;
import org.springframework.stereotype.Component;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 19:00
 */

@Component
public class AverageBalanceNotRequired implements IAverageBalanceCheck {
    @Override
    public boolean averageBalanceCheck(AccountDetailDO accountDetailDO) {
        return true;
    }
}

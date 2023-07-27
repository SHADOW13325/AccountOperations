package com.setuInterview.AccountOperations.Service.Behaviours;

import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:56
 */

public interface IAverageBalanceCheck {

    public abstract boolean averageBalanceCheck(AccountDetailDO accountDetailDO);
}

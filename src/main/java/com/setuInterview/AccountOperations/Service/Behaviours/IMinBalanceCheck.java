package com.setuInterview.AccountOperations.Service.Behaviours;

import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:44
 */

public interface IMinBalanceCheck {

    public abstract boolean minBalanceCheck(AccountDetailDO accountDetailDO);
}

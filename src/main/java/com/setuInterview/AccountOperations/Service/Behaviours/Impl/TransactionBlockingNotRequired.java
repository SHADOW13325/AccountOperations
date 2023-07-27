package com.setuInterview.AccountOperations.Service.Behaviours.Impl;

import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Service.Behaviours.IBlockTransaction;
import org.springframework.stereotype.Component;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:57
 */

@Component
public class TransactionBlockingNotRequired implements IBlockTransaction {


    @Override
    public boolean blockTransaction(AccountDetailDO accountDetailDO) {
        return true;
    }
}

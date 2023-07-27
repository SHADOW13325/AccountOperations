package com.setuInterview.AccountOperations.Service.Behaviours.Impl;

import com.setuInterview.AccountOperations.Models.Enums.AccountType;
import com.setuInterview.AccountOperations.Models.Enums.TransactionType;
import com.setuInterview.AccountOperations.Repository.DAOService.DAOService;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Service.Behaviours.IBlockTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 11:08
 */

@Component
public class ChargeOnTransaction implements IBlockTransaction {

    private final DAOService daoService;

    @Autowired
    public ChargeOnTransaction(DAOService daoService) {
        this.daoService = daoService;
    }
    @Override
    public boolean blockTransaction(AccountDetailDO accountDetailDO) {
        AccountType accountType = AccountType.getAccountEnum(accountDetailDO.getAccountType());

        long count = daoService.getTransactionCountForCurrentMonth(accountDetailDO.getAccountNumber(), TransactionType.Withdrawal.getTransactionName());

        if(accountType.getWithdrawalLimit() <= count) {
            accountDetailDO.setTransactionCharge(accountType.getWithdrawalCharge());
        }
        return true;
    }
}

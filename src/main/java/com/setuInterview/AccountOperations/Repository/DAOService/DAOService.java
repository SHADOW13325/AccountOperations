package com.setuInterview.AccountOperations.Repository.DAOService;

import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;
import com.setuInterview.AccountOperations.Repository.Entities.UserDetailDO;

import java.util.List;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 06:33
 */

public interface DAOService {

    public void save(UserDetailDO userDetailDO);

    public void saveOrUpdate(AccountDetailDO accountDetailDO);

    public void save(TransactionHistoryDO transactionHistoryDO);

    public AccountDetailDO getAccount(String accountNumber);

    public UserDetailDO getUserDetails(String accountNumber);

    public List<TransactionHistoryDO> getTransactionsForPast30Days(String accountNumber);

    public long getTransactionCountForCurrentMonth(String accountNumber, String transactionType);
}

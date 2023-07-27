package com.setuInterview.AccountOperations.Repository.DAOService.Impl;

import com.setuInterview.AccountOperations.Repository.DAOService.DAOService;
import com.setuInterview.AccountOperations.Repository.DAOService.Repositories.AccountDetailRepository;
import com.setuInterview.AccountOperations.Repository.DAOService.Repositories.TransactionHistoryRepository;
import com.setuInterview.AccountOperations.Repository.DAOService.Repositories.UserDetailRepository;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;
import com.setuInterview.AccountOperations.Repository.Entities.UserDetailDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 06:29
 */

@Component
public class DAOServiceImpl implements DAOService {


    private final UserDetailRepository userDetailRepository;
    private final AccountDetailRepository accountDetailRepository;
    private final TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    public DAOServiceImpl(UserDetailRepository userDetailRepository, AccountDetailRepository accountDetailRepository,
                          TransactionHistoryRepository transactionHistoryRepository) {
        this.userDetailRepository = userDetailRepository;
        this.accountDetailRepository = accountDetailRepository;
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    @Override
    public void save(UserDetailDO userDetailDO) {
        userDetailRepository.save(userDetailDO);
    }

    @Override
    public void saveOrUpdate(AccountDetailDO accountDetailDO) {
        accountDetailRepository.save(accountDetailDO);
    }

    @Override
    public void save(TransactionHistoryDO transactionHistoryDO) {
        transactionHistoryRepository.save(transactionHistoryDO);
    }

    @Override
    public AccountDetailDO getAccount(String accountNumber) {
        return accountDetailRepository.findFirstByAccountNumber(accountNumber);
    }

    @Override
    public UserDetailDO getUserDetails(String accountNumber) {
        return userDetailRepository.findFirstByAccountNumber(accountNumber);
    }

    public List<TransactionHistoryDO> getTransactionsForPast30Days(String accountNumber){
        LocalDateTime localDate = LocalDate.now().minusDays(30).atStartOfDay();
        return transactionHistoryRepository.findByAccountNumberAndCreatedOnGreaterThanEqualOrderByCreatedOn(accountNumber, localDate);
    }

    public long getTransactionCountForCurrentMonth(String accountNumber, String transactionType){
        LocalDateTime localDateTime = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        List<TransactionHistoryDO> transactionHistoryDOList = transactionHistoryRepository.findByAccountNumberAndCreatedOnGreaterThanEqualAndTransactionType(accountNumber,localDateTime,transactionType);
        return transactionHistoryDOList.stream().count();
    }
}

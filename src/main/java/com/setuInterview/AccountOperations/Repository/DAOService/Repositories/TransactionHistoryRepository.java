package com.setuInterview.AccountOperations.Repository.DAOService.Repositories;

import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 06:28
 */

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistoryDO, Integer> {

    public List<TransactionHistoryDO> findByAccountNumberAndCreatedOnGreaterThanEqualOrderByCreatedOn(String accountNumber, LocalDateTime createdOn);
    public List<TransactionHistoryDO> findByAccountNumberAndCreatedOnGreaterThanEqualAndTransactionType(String accountNumber,
                                                      LocalDateTime createdOn, String transactionType);
}

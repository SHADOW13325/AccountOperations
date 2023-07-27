package com.setuInterview.AccountOperations.Service.Behaviours.Impl;

import com.setuInterview.AccountOperations.Models.Enums.AccountType;
import com.setuInterview.AccountOperations.Models.Enums.TransactionType;
import com.setuInterview.AccountOperations.Repository.DAOService.DAOService;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;
import com.setuInterview.AccountOperations.Service.Behaviours.IAverageBalanceCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 19:00
 */

@Component
public class AverageBalanceRequired implements IAverageBalanceCheck {

    private final DAOService daoService;

    @Autowired
    public AverageBalanceRequired(DAOService daoService) {
        this.daoService = daoService;
    }

    @Override
    public boolean averageBalanceCheck(AccountDetailDO accountDetailDO) {

        AccountType accountType = AccountType.getAccountEnum(accountDetailDO.getAccountType());
        List<TransactionHistoryDO> transactionHistoryDOList = daoService.getTransactionsForPast30Days(accountDetailDO.getAccountNumber());
        long averageBalance = 0;

        if (transactionHistoryDOList.size() > 0) {
//            Collections.sort(transactionHistoryDOList, transactionHistoryComparator);

            LocalDateTime localDateTime = LocalDate.now().withDayOfMonth(1).atStartOfDay();
            long tempBalance = 0;
            if (transactionHistoryDOList.get(0).getTransactionType().equals(TransactionType.Withdrawal.getTransactionName())) {
                tempBalance = transactionHistoryDOList.get(0).getFinalBalance() + transactionHistoryDOList.get(0).getTransactionBalance();
            } else if (transactionHistoryDOList.get(0).getTransactionType().equals(TransactionType.Deposit.getTransactionName())) {
                tempBalance = transactionHistoryDOList.get(0).getFinalBalance() - transactionHistoryDOList.get(0).getTransactionBalance();
            }

            LocalDate localDate = LocalDate.now().minusDays(30);
            long totalBalance = 0;

            for (int i = 0; i < transactionHistoryDOList.size(); i++){
                LocalDate transactionDate = transactionHistoryDOList.get(i).getCreatedOn().toLocalDate();
                if (transactionDate.compareTo(localDate) == 0){
                    tempBalance = transactionHistoryDOList.get(i).getFinalBalance();
                    continue;
                }
                totalBalance += tempBalance * ChronoUnit.DAYS.between(localDate, transactionDate);
                localDate = transactionDate;
                tempBalance = transactionHistoryDOList.get(i).getFinalBalance();
            }

            totalBalance += tempBalance * ChronoUnit.DAYS.between(localDate, LocalDate.now().plusDays(1));

            averageBalance = totalBalance / 30;
        }

        return (accountType.getAverageBalance() <= averageBalance);

    }
}

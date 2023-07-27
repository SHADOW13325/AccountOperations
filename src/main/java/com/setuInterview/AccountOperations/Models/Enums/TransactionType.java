package com.setuInterview.AccountOperations.Models.Enums;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 12:24
 */

public enum TransactionType {
    Deposit("deposit"), Withdrawal("withdrawal");

    public String transactionName;

    TransactionType(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getTransactionName() {
        return transactionName;
    }
}

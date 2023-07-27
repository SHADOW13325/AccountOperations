package com.setuInterview.AccountOperations.Repository.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:26
 */

@Entity
@Table(name = "txn_history", indexes = {@Index(name = "idx_acc_no", columnList = "account_number"),
        @Index(name = "idx_crea_on", columnList = "created_on")})
public class TransactionHistoryDO {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "txn_type")
    private String transactionType;

    @Column(name = "txn_balance")
    private long transactionBalance;

    @Column(name = "final_balance")
    private long finalBalance;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    public TransactionHistoryDO(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public long getTransactionBalance() {
        return transactionBalance;
    }

    public void setTransactionBalance(long transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    public long getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(long finalBalance) {
        this.finalBalance = finalBalance;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}

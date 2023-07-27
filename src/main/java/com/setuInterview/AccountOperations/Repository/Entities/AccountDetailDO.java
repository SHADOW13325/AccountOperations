package com.setuInterview.AccountOperations.Repository.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:05
 */

@Entity
@Table(name = "account_detail", indexes = {@Index(name = "idx_acc_no", columnList = "account_number", unique = true)})
public class AccountDetailDO {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;


    @Column(name = "total_balance")
    private long balance;

    @Column(name = "account_type")
    private int accountType;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    private transient int transactionCharge;

    public AccountDetailDO(String accountNumber, int accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0;
        this.updatedOn = LocalDateTime.now();

    }

    public AccountDetailDO(){

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

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public int getTransactionCharge() {
        return transactionCharge;
    }

    public void setTransactionCharge(int transactionCharge) {
        this.transactionCharge = transactionCharge;
    }
}

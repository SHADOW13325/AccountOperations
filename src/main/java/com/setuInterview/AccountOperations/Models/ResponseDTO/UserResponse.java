package com.setuInterview.AccountOperations.Models.ResponseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 22:30
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private long userId;
    private long accountId;
    private String name;
    private String mobile;
    private String accountNumber;
    private String accountType;
    private long balance;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<TransactionHistoryDO> transactionHistory;
    private HTTPResponse httpResponse;

    public UserResponse(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public List<TransactionHistoryDO> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<TransactionHistoryDO> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public HTTPResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HTTPResponse httpResponse) {
        this.httpResponse = httpResponse;
    }
}

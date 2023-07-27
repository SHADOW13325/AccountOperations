package com.setuInterview.AccountOperations.Models.ResponseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 12:31
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionResponse {

    private long accountId;
    private String accountNumber;
    private String accountType;
    private long previousBalance;
    private long finalBalance;
    private long amountDeposited;
    private long amountWithdrawn;
    private long transactionCharge;
    private LocalDateTime createdOn;
    private HTTPResponse httpResponse;

    public TransactionResponse(){
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(long previousBalance) {
        this.previousBalance = previousBalance;
    }

    public long getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(long finalBalance) {
        this.finalBalance = finalBalance;
    }

    public long getAmountDeposited() {
        return amountDeposited;
    }

    public void setAmountDeposited(long amountDeposited) {
        this.amountDeposited = amountDeposited;
    }

    public long getAmountWithdrawn() {
        return amountWithdrawn;
    }

    public void setAmountWithdrawn(long amountWithdrawn) {
        this.amountWithdrawn = amountWithdrawn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public HTTPResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HTTPResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public long getTransactionCharge() {
        return transactionCharge;
    }

    public void setTransactionCharge(long transactionCharge) {
        this.transactionCharge = transactionCharge;
    }
}

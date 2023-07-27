package com.setuInterview.AccountOperations.Constants;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:34
 */

public enum CustomHTTPCodes {

    AccountCreated("account created successfully", "SETU-2000"),
    AccountNotFound("account not found", "SETU-2001"),
    WithDrawalLimitReached("you have exceeded the withdrawal limit for the month","SETU-2002"),
    BalanceLessThanMinimum("your account balance is less than minimum", "SETU-2003"),
    AverageBalanceLessThanMinimum("your average balance is less then minimum for the past 30 days","SETU-2004"),
    InsufficientBalance("your account has insufficient funds","SETU-2005"),
    WithDrawalSuccessful("money withdrawn successfully", "SETU-2006"),
    DepositSuccessful("money deposited successfully", "SETU-2007"),
    HistorySent("transaction history successfully sent", "SETU-2008")


    ;

    private String message;
    private String code;
    CustomHTTPCodes(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}

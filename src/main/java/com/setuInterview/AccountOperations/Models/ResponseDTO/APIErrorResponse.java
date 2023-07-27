package com.setuInterview.AccountOperations.Models.ResponseDTO;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 14:14
 */

public class APIErrorResponse {

    public String statusCode;
    public String statusMessage;

    public APIErrorResponse(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}

package com.setuInterview.AccountOperations.Models.ResponseDTO;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 22:31
 */

public class HTTPResponse {

    public String statusCode;
    public String statusMessage;

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public HTTPResponse(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public HTTPResponse(){}


}

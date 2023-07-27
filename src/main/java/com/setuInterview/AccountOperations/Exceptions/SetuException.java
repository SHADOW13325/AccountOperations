package com.setuInterview.AccountOperations.Exceptions;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 11:50
 */

public class SetuException extends RuntimeException{

    public String code;
    public String message;

    public SetuException(String message, String code) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

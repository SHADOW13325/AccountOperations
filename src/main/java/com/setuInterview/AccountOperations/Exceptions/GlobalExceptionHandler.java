package com.setuInterview.AccountOperations.Exceptions;

import com.setuInterview.AccountOperations.Constants.ErrorConstants;
import com.setuInterview.AccountOperations.Models.ResponseDTO.APIErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 20:50
 */

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = {ConstraintViolationException.class})
//    public ResponseEntity<APIErrorResponse> handleException(ConstraintViolationException validationException){
//
//        List<String> errorMessages = validationException.getConstraintViolations().stream().
//                map(violation -> violation.getMessageTemplate()).collect(Collectors.toList());
//
//        APIErrorResponse apiErrorResponse = new APIErrorResponse(ErrorConstants.BADREQUEST, errorMessages.toString());
//
//        return new ResponseEntity<>(apiErrorResponse,HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(value = {SetuException.class})
    public ResponseEntity<APIErrorResponse> handleException(SetuException setuException){
        APIErrorResponse apiErrorResponse = new APIErrorResponse(setuException.getCode(), setuException.getMessage());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.OK);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<APIErrorResponse> handleException(MethodArgumentNotValidException exception){
        List<String> errorMessages = exception.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        APIErrorResponse apiErrorResponse = new APIErrorResponse(ErrorConstants.BADREQUEST, errorMessages.toString());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<APIErrorResponse> handleException(HttpMessageNotReadableException exception){
        APIErrorResponse apiErrorResponse = new APIErrorResponse(ErrorConstants.BADREQUEST, "Please provide a proper request.  " + exception.getMessage());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<APIErrorResponse> handleException(HttpMediaTypeNotSupportedException exception){
        APIErrorResponse apiErrorResponse = new APIErrorResponse(ErrorConstants.BADREQUEST, exception.getMessage());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<APIErrorResponse> handleException(MissingServletRequestParameterException exception){
        APIErrorResponse apiErrorResponse = new APIErrorResponse(ErrorConstants.BADREQUEST, exception.getMessage());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Throwable.class})
    public ResponseEntity<APIErrorResponse> handleException(Throwable throwable) {
        APIErrorResponse apiErrorResponse = new APIErrorResponse(ErrorConstants.INTERNALSERVERERROR, throwable.getMessage());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

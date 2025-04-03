package com.fruit_shop.exception;

import com.fruit_shop.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //handing AppException
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException e){
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(false);
        apiResponse.setErrorCode(errorCode.getErrorCode());
        apiResponse.setErrorMessage(errorCode.getErrorMessage());
        apiResponse.setData(null);
        return ResponseEntity
                .status(errorCode.getStatusCode())
                .body(apiResponse);
    }

    //handing validation
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handingValidation(MethodArgumentNotValidException e){
        String enumKey = e.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.valueOf(enumKey);
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(false);
        apiResponse.setErrorCode(errorCode.getErrorCode());
        apiResponse.setErrorMessage(errorCode.getErrorMessage());
        apiResponse.setData(null);
        return ResponseEntity
                .status(errorCode.getStatusCode())
                .body(apiResponse);
    }

}

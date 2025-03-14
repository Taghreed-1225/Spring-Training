package com.adminPanel.app.controller;


import com.adminPanel.app.exception.BadRequestException;
import com.adminPanel.app.exception.responses.ProductErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handlerForProductNotFound(com.adminPanel.app.exception.ProductExceptionHandler exception){


        ProductErrorResponse errorResponse =new ProductErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_FOUND.value()); // or write 404
        errorResponse.setMsg(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>( errorResponse ,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handlerForBadRequestException  (BadRequestException exception){


        ProductErrorResponse errorResponse =new ProductErrorResponse();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.value()); // or write 404
        errorResponse.setMsg(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>( errorResponse ,HttpStatus.BAD_REQUEST);
    }





}

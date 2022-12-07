package com.demo.demo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> HandleApiRequestException(

            //Get Exception to be Handle
            ApiRequestException e
        ){

        //Build the Payload for the Client
ApiException apiException = new ApiException(
        e.getMessage(),
        e,
        HttpStatus.BAD_REQUEST,
        ZonedDateTime.now()
);

        //Send the Response to client
        return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> HandleApiRequestException(

            //Get Exception to be Handle
            NotFoundException e
        ){

        //Build the Payload for the Client
ApiException apiException = new ApiException(
        e.getMessage(),
        e,
        HttpStatus.NOT_FOUND,
        ZonedDateTime.now()
);

        //Send the Response to client
        return new ResponseEntity<>(apiException,HttpStatus.NOT_FOUND);
    }
}

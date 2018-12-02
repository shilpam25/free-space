package com.adobe.codingchallenge.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class FreeSpaceControllerAdvice {

    @ExceptionHandler({NoSuchElementException.class})
        void handleNoSuchElementException(HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    void handleIllegalArgumentException(HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({MalformedURLException.class})
    void handleMalformedURLException(HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

}

package com.tenpines.tusLibros.web;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class GlobalExceptionHandlingController extends IOException {


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleDefaultException(HttpServletResponse response, Exception exception)
            throws Exception {
        if (AnnotationUtils.findAnnotation(exception.getClass(),
                ResponseStatus.class) != null)
            throw exception;
        HttpStatus statusActual = HttpStatus.BAD_REQUEST;
        String message = exception.getMessage();
        message = "Error " + statusActual + " - " + message;

        return new ResponseEntity(message,statusActual);

    }
}

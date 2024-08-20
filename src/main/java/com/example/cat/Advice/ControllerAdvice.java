package com.example.cat.Advice;

import com.example.cat.Api.ApiException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {








    @ExceptionHandler(value = ApiException.class)


    public ResponseEntity ApiException (ApiException e ){
        String message = e.getMessage();

        return ResponseEntity.status(400 ).body(message);
    }


    //this will catch if the user ask for api not present
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException (NoResourceFoundException e ){
        String message = e.getMessage();
        return ResponseEntity.status(404 ).body(message);

    }


    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException (DataIntegrityViolationException e ){
        String message = e.getMessage();
        return ResponseEntity.status(400 ).body(message);
    }


    // this will catch the missmatch like if they want int and you provide string
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException (MethodArgumentTypeMismatchException e ){
        String message = e.getMessage();
        return ResponseEntity.status(400 ).body(message);
    }

    //this will catch when the api like post or put required a body but doesnt receive
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException (HttpMessageNotReadableException e ){
        String message = e.getMessage();
        return ResponseEntity.status(400 ).body(message);
    }

    // this will catch the mismatch of attribute type
    //its happen in vaccinationDate http://localhost:8080/api/v1/healthrecords/add
    @ExceptionHandler(value = UnexpectedTypeException.class)
    public ResponseEntity UnexpectedTypeException (UnexpectedTypeException e ){
        String message = e.getMessage();
        return ResponseEntity.status(400 ).body(message);
    }
    // this will catch when i try to but null to the states filed
    //http://localhost:8080/api/v1/adoptionrequests/add
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity ConstraintViolationException (ConstraintViolationException e ){
        String message = e.getMessage();
        return ResponseEntity.status(400 ).body(message);
    }

    // this handle if a request get instead of post
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException (HttpRequestMethodNotSupportedException e ){
        String message = e.getMessage();
        return ResponseEntity.status(400 ).body(message);
    }






}

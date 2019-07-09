package com.example.kproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoRecordFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse NoRecordFoundException(NoRecordFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("No Record Found To View");
        errorResponse.setDetails(ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = NoRecordFoundToUpdate.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse NoRecordFoundToUpdateException(NoRecordFoundToUpdate ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("No Record Found To Update");
        errorResponse.setDetails(ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = NoRecordFoundToDelete.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse NoRecordFoundToDeleteException(NoRecordFoundToDelete ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("No Record Found To Delete");
        errorResponse.setDetails(ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = NoRecordFoundForeignKey.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse NoRecordFoundForeignKeyException(NoRecordFoundForeignKey ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("No Record Found With GroupID");
        errorResponse.setDetails(ex.getMessage());
        return errorResponse;
    }
}
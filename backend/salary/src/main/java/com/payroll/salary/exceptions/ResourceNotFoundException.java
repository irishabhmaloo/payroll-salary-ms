package com.payroll.salary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String resource, String fieldName, String dateFrom, String dateTo){
        super(String.format("%s not found for %s - %s to %s", resource, fieldName, dateFrom, dateTo));
    }

}

package com.payroll.salary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class SalaryAlreadyExistsException extends RuntimeException{
    public SalaryAlreadyExistsException(String message) {
        super(message);
    }
}

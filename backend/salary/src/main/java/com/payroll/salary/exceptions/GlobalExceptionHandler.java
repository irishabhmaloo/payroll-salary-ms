package com.payroll.salary.exceptions;

import com.payroll.salary.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                ex.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SalaryAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleSalaryAlreadyExistsException(SalaryAlreadyExistsException ex, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                ex.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.ALREADY_REPORTED,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.ALREADY_REPORTED);
    }
}

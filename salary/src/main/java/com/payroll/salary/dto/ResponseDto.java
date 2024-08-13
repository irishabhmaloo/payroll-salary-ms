package com.payroll.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data @AllArgsConstructor @NoArgsConstructor
public class ResponseDto {

    private String message;
    private HttpStatus statusCode;
//
//    public ResponseDto(String unableToUpdate, HttpStatus httpStatus) {
//    }
}

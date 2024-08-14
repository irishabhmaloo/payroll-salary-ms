package com.payroll.salary.controller;

import com.payroll.salary.dto.SalaryDetailsDto;
import com.payroll.salary.service.ISalaryDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class SalaryDetailsController {

    private ISalaryDetailsService iSalaryDetailsService;

    @GetMapping("/fetch-salary-details")
    public ResponseEntity<SalaryDetailsDto> getSalaryDetails(@RequestParam long empId){
        SalaryDetailsDto salaryDetailsDto = iSalaryDetailsService.fetchSalaryDetails(empId);
        return ResponseEntity.status(HttpStatus.OK).body(salaryDetailsDto);
    }
}

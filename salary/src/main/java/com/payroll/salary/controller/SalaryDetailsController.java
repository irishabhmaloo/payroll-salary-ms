package com.payroll.salary.controller;

import com.payroll.salary.dto.SalaryDetailsDto;
import com.payroll.salary.service.ISalaryDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:9090")
public class SalaryDetailsController {

    private ISalaryDetailsService iSalaryDetailsService;

    @GetMapping("/fetch-salary-details")
    public ResponseEntity<SalaryDetailsDto> getSalaryDetails(@RequestParam long empId){
        SalaryDetailsDto salaryDetailsDto = iSalaryDetailsService.fetchSalaryDetails(empId);
        return ResponseEntity.status(HttpStatus.OK).body(salaryDetailsDto);
    }
}

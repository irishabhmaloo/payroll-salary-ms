package com.payroll.salary.service.clients;

import com.payroll.salary.dto.PayrollDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("payroll")
public interface PayrollFeignClient {

    @GetMapping("/api/fetch")
    ResponseEntity<List<PayrollDto>> fetchPayrollDetails(@RequestParam long empId);
}

package com.payroll.salary.service.impl;

import com.payroll.salary.dto.PayrollDto;
import com.payroll.salary.dto.SalaryDetailsDto;
import com.payroll.salary.dto.SalaryDto;
import com.payroll.salary.entity.Salary;
import com.payroll.salary.exceptions.ResourceNotFoundException;
import com.payroll.salary.mapper.SalaryMapper;
import com.payroll.salary.repository.SalaryRepository;
import com.payroll.salary.service.ISalaryDetailsService;
import com.payroll.salary.service.clients.PayrollFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SalaryDetailsServiceImpl implements ISalaryDetailsService {

    private SalaryRepository salaryRepository;
    private PayrollFeignClient payrollFeignClient;

    @Override
    public SalaryDetailsDto fetchSalaryDetails(long empId) {
        List<Salary> salaryList = salaryRepository.findByEmpId(empId);

        if(salaryList.isEmpty()){
            throw new ResourceNotFoundException("Salary", "Emp ID", "null", "null");
        }

        SalaryDetailsDto salaryDetailsDto = SalaryMapper.mapToSalaryDetailsDto(empId, salaryList, new SalaryDetailsDto());

        ResponseEntity<List<PayrollDto>> payrollDtoResponseEntity = payrollFeignClient.fetchPayrollDetails(empId);
        salaryDetailsDto.setPayrollDtoList(payrollDtoResponseEntity.getBody());

        return salaryDetailsDto;
    }
}

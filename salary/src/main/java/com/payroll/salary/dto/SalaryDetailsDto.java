package com.payroll.salary.dto;

import com.payroll.salary.entity.Salary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDetailsDto {
    private long empId;
    private List<Salary> salaryList;
    private List<PayrollDto> payrollDtoList;
}

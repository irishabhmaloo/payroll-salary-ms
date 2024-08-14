package com.payroll.salary.service;

import com.payroll.salary.dto.SalaryDetailsDto;

public interface ISalaryDetailsService {
    SalaryDetailsDto fetchSalaryDetails(long empId);
}

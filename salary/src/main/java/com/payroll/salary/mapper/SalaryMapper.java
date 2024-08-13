package com.payroll.salary.mapper;

import com.payroll.salary.dto.SalaryDto;
import com.payroll.salary.entity.Salary;

public class SalaryMapper {

    // map dto to entity
    public static Salary mapToSalary(SalaryDto salaryDto, Salary salary) {

        salary.setEmpId(salaryDto.getEmpId());
        salary.setDateFrom(salaryDto.getDateFrom());
        salary.setDateTo(salaryDto.getDateTo());
        salary.setBasicAmt(salaryDto.getBasicAmt());

        return salary;
    }

    // map entity to dto
    public static SalaryDto mapToSalaryDto(Salary salary, SalaryDto salaryDto) {

        salaryDto.setEmpId(salary.getEmpId());
        salaryDto.setDateFrom(salary.getDateFrom());
        salaryDto.setDateTo(salary.getDateTo());
        salaryDto.setBasicAmt(salary.getBasicAmt());

        return salaryDto;
    }
}

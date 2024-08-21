package com.payroll.salary.service;

import com.payroll.salary.dto.SalaryDto;

import java.util.List;

public interface ISalaryService {

    // create new salary
    void createSalary(SalaryDto salaryDto);

    // fetch salary details of a particular employee
    SalaryDto fetchSalaryDetails(long empId, String dateFrom, String dateTo);

    // fetch all salary details of a particular employee
    List<SalaryDto> fetchAllSalaryDetails(Long empId);

    // update a particular salary
    boolean updateSalaryDetails(SalaryDto salaryDto);

    // delete a particular salary instance
    boolean deleteOneSalary(long empId, String dateFrom, String dateTo);
}

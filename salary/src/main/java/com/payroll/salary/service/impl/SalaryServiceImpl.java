package com.payroll.salary.service.impl;

import com.payroll.salary.dto.SalaryDto;
import com.payroll.salary.entity.Salary;
import com.payroll.salary.exceptions.ResourceNotFoundException;
import com.payroll.salary.exceptions.SalaryAlreadyExistsException;
import com.payroll.salary.mapper.SalaryMapper;
import com.payroll.salary.repository.SalaryRepository;
import com.payroll.salary.service.ISalaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SalaryServiceImpl implements ISalaryService {

    private SalaryRepository salaryRepository;

    // create new salary
    @Override
    public void createSalary(SalaryDto salaryDto) {
        String dateFrom = salaryDto.getDateFrom();
        String dateTo = salaryDto.getDateTo();
        Long empId = salaryDto.getEmpId();

        Optional<Salary> foundSalary = salaryRepository.findByEmpIdAndDateFromAndDateTo(empId,dateFrom, dateTo);
//        System.out.println("check:" + foundSalary.stream());

        if (foundSalary.isPresent()) {
            throw new SalaryAlreadyExistsException("Salary already exists for given time period!");
        }

        Salary salary = SalaryMapper.mapToSalary(salaryDto, new Salary());
        salaryRepository.save(salary);
    }

    // fetch salary details of a particular employee
    public SalaryDto fetchSalaryDetails(long empId, String dateFrom, String dateTo) {
        Salary salary = salaryRepository.findByEmpIdAndDateFromAndDateTo(empId,dateFrom, dateTo).orElseThrow(
                () -> new ResourceNotFoundException("Salary", "Emp ID", dateFrom, dateTo)
        );

        SalaryDto salaryDto = SalaryMapper.mapToSalaryDto(salary, new SalaryDto());

        return salaryDto;
    }

    // update a particular salary
    public boolean updateSalaryDetails(SalaryDto salaryDto) {
        boolean isUpdated = false;

        String dateFrom = salaryDto.getDateFrom();
        String dateTo = salaryDto.getDateTo();
        Long empId = salaryDto.getEmpId();

        Salary salary = salaryRepository.findByEmpIdAndDateFromAndDateTo(empId,dateFrom, dateTo).orElseThrow(
                () -> new ResourceNotFoundException("Salary", "Emp ID", dateFrom, dateTo)
        );

        if (salary != null) {
            SalaryMapper.mapToSalary(salaryDto, salary);

            salaryRepository.save(salary);

            isUpdated = true;
        }

        return isUpdated;
    }

    // delete a particular salary instance
    public boolean deleteOneSalary(long empId, String dateFrom, String dateTo) {
        boolean isDeleted = false;

        Salary salary = salaryRepository.findByEmpIdAndDateFromAndDateTo(empId,dateFrom, dateTo).orElseThrow(
                () -> new ResourceNotFoundException("Salary", "Emp ID", dateFrom, dateTo)
        );

        if (salary != null) {
            salaryRepository.delete(salary);
            isDeleted = true;
        }

        return isDeleted;
    }
}

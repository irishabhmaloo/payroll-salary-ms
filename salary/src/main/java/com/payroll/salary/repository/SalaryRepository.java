package com.payroll.salary.repository;

import com.payroll.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    Optional<Salary> findByEmpIdAndDateFromAndDateTo (Long empId, String dateFrom, String dateTo);
}

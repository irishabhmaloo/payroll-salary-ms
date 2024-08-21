package com.payroll.salary.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salary")
@Data @AllArgsConstructor @NoArgsConstructor
public class Salary extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;

    @NotNull(message = "Employee ID can not be empty")
    private Long empId;
    private String dateFrom;
    private String dateTo;
    private long basicAmt;
}

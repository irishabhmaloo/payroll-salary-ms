package com.payroll.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class SalaryDto {

    private long empId;
    private String dateFrom;
    private String dateTo;
    private long basicAmt;
}

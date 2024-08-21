package com.payroll.Employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class EmployeeLeaveDetailsDto {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String role;
    private String mobileNumber;
    private List<LeaveDto> leaveDtoList;
}


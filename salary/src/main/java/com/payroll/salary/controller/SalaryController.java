package com.payroll.salary.controller;

import com.payroll.salary.dto.ResponseDto;
import com.payroll.salary.dto.SalaryDto;
import com.payroll.salary.service.ISalaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
// documentation
@Tag(
        name = "Salary Controller",
        description = "Salary controller for Payroll project"
)
@Validated
public class SalaryController {

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private ISalaryService iSalaryService;

    public SalaryController(ISalaryService iSalaryService) {
        this.iSalaryService = iSalaryService;
    }

    // documentation
    @Operation(
            summary = "Create new salary for employee"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Salary successfully created"
    )
    @PostMapping("/create-salary")
    public ResponseEntity<ResponseDto> createSalary (@RequestBody SalaryDto salaryDto) {
        iSalaryService.createSalary(salaryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Created Succesfully",HttpStatus.CREATED));
    }


    @Operation(
            summary = "Fetch a particular salary for an employee"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Salary successfully fetched"
    )
    @GetMapping("/fetch-salary")
    public ResponseEntity<SalaryDto> fetchSalaryDetails(@RequestParam long empId, String dateFrom, String dateTo) {
        SalaryDto salaryDto = iSalaryService.fetchSalaryDetails(empId, dateFrom, dateTo);
        return ResponseEntity.status(HttpStatus.OK)
                .body(salaryDto);
    }


    @Operation(
            summary = "Update a particular salary instance of an employee"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Salary successfully updated"
    )
    @PutMapping("/update-salary")
    public ResponseEntity<ResponseDto> updateSalaryDetails(@RequestBody SalaryDto salaryDto) {
        boolean isUpdated = iSalaryService.updateSalaryDetails(salaryDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto("Updated successfully", HttpStatus.ACCEPTED));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto("Unable to update", HttpStatus.BAD_REQUEST));
        }
    }

    @Operation(
            summary = "Delete a particular salary instance of an employee"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Salary successfully deleted"
    )
    @DeleteMapping("/delete-salary")
    public ResponseEntity<ResponseDto> deleteOneSalary(@RequestParam long empId, String dateFrom, String dateTo){
        boolean isDeleted = iSalaryService.deleteOneSalary(empId, dateFrom, dateTo);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto("Deleted successfully", HttpStatus.OK));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto("Unable to delete", HttpStatus.BAD_REQUEST));
        }
    }

    @Operation(
            summary = "Get the build info"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Build info successfully fetched"
    )
    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(buildVersion);
    }
}

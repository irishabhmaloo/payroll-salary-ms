import com.payroll.salary.controller.SalaryController;
import com.payroll.salary.dto.ResponseDto;
import com.payroll.salary.dto.SalaryDto;
import com.payroll.salary.service.ISalaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SalaryControllerTest {

    @Mock
    private ISalaryService iSalaryService;

    @InjectMocks
    private SalaryController salaryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSalary() {
        // Arrange
        SalaryDto salaryDto = new SalaryDto(1L, "2023-01-01", "2023-01-31", 5000L);

        // Act
        ResponseEntity<ResponseDto> response = salaryController.createSalary(salaryDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Created Succesfully", response.getBody().getMessage());
        assertEquals(HttpStatus.CREATED, response.getBody().getStatusCode());

        // Verify the service method is called once
        verify(iSalaryService, times(1)).createSalary(salaryDto);
    }

    @Test
    void testFetchSalaryDetails() {
        // Arrange
        long empId = 1L;
        String dateFrom = "2023-01-01";
        String dateTo = "2023-01-31";
        SalaryDto salaryDto = new SalaryDto(empId, dateFrom, dateTo, 5000L);

        when(iSalaryService.fetchSalaryDetails(empId, dateFrom, dateTo)).thenReturn(salaryDto);

        // Act
        ResponseEntity<SalaryDto> response = salaryController.fetchSalaryDetails(empId, dateFrom, dateTo);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(salaryDto, response.getBody());

        // Verify the service method is called once
        verify(iSalaryService, times(1)).fetchSalaryDetails(empId, dateFrom, dateTo);
    }

    @Test
    void testFetchAllSalaryDetails() {
        // Arrange
        long empId = 1L;
        List<SalaryDto> mockSalaryList = new ArrayList<>();

        SalaryDto salaryDto1 = new SalaryDto(empId, "2023-01-01", "2023-01-31", 5000L);
        SalaryDto salaryDto2 = new SalaryDto(empId, "2023-02-01", "2023-02-28", 5100L);

        mockSalaryList.add(salaryDto1);
        mockSalaryList.add(salaryDto2);

        when(iSalaryService.fetchAllSalaryDetails(empId)).thenReturn(mockSalaryList);

        // Act
        ResponseEntity<List<SalaryDto>> response = salaryController.fetchAllSalaryDetails(empId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals(mockSalaryList, response.getBody());

        // Verify the service method is called once
        verify(iSalaryService, times(1)).fetchAllSalaryDetails(empId);
    }

    @Test
    void testUpdateSalaryDetails() {
        // Arrange
        SalaryDto salaryDto = new SalaryDto(1L, "2023-01-01", "2023-01-31", 5000L);
        when(iSalaryService.updateSalaryDetails(salaryDto)).thenReturn(true);

        // Act
        ResponseEntity<ResponseDto> response = salaryController.updateSalaryDetails(salaryDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated successfully", response.getBody().getMessage());
        assertEquals(HttpStatus.ACCEPTED, response.getBody().getStatusCode());

        // Verify the service method is called once
        verify(iSalaryService, times(1)).updateSalaryDetails(salaryDto);
    }

    @Test
    void testDeleteOneSalary() {
        // Arrange
        long empId = 1L;
        String dateFrom = "2023-01-01";
        String dateTo = "2023-01-31";
        when(iSalaryService.deleteOneSalary(empId, dateFrom, dateTo)).thenReturn(true);

        // Act
        ResponseEntity<ResponseDto> response = salaryController.deleteOneSalary(empId, dateFrom, dateTo);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted successfully", response.getBody().getMessage());
        assertEquals(HttpStatus.OK, response.getBody().getStatusCode());

        // Verify the service method is called once
        verify(iSalaryService, times(1)).deleteOneSalary(empId, dateFrom, dateTo);
    }
}
package com.payroll.salary;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//Enabling Auditing
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
// Documentation
@OpenAPIDefinition(
		info = @Info(
				title = "Salary MS REST API",
				description = "REST CRUD Operation for Salary Entity",
				contact = @Contact(
						name = "Rishabh Ramesh Maloo",
						email = "rishabh.maloo@ukg.com"
						// url = ""
				)

		)
)
@EnableFeignClients
public class SalaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaryApplication.class, args);
	}

}

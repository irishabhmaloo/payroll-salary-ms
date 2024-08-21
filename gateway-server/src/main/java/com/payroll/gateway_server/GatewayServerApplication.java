package com.payroll.gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayServerApplication {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder){
		return builder.routes().
				route(p -> p
						.path("/ukg/payroll/employee/**")
						.filters(f -> f.rewritePath("/ukg/payroll/employee/(?<segment>.*)", "/${segment}"))
						.uri("lb://EMPLOYEE")
				).
				route(p -> p
						.path("/ukg/payroll/cards/**")
						.filters(f -> f.rewritePath("//ukg/payroll/leaves/(?<segment>.*)", "/${segment}"))
						.uri("lb://LEAVES")
				).route(p -> p
						.path("/ukg/payroll/loans/**")
						.filters(f -> f.rewritePath("/ukg/payroll/salary/(?<segment>.*)", "/${segment}"))
						.uri("lb://SALARY")
				).
				build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

}

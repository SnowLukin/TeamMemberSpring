package com.snowlukin.springlab.EmployeeUni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EmployeeUniApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeUniApplication.class, args);
	}

}

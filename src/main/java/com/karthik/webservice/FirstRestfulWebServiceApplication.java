package com.karthik.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("*com.karthik.webservice.*")
@SpringBootApplication
public class FirstRestfulWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRestfulWebServiceApplication.class, args);
	}
}

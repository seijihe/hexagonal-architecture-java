package com.example.cpf_validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CpfValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpfValidationApplication.class, args);
	}

}

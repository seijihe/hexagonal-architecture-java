package com.example.cpf_validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.cpf_validation.application.core.usecases.InsertCustomerUseCase;
import com.example.cpf_validation.application.ports.out.FindAddressByZipCodeOutputPort;
import com.example.cpf_validation.application.ports.out.InsertCustomerOutputPort;

@Configuration 
public class InsertCustomerConfig {
    
    @Bean 
    public InsertCustomerUseCase insertCustomerUseCase(
        FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
        InsertCustomerOutputPort insertCustomerOutputPort
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeOutputPort, insertCustomerOutputPort);
    }

}

package com.example.cpf_validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.cpf_validation.application.core.usecases.UpdateCustomerUseCase;
import com.example.cpf_validation.application.ports.in.FindCustomerByIdInputPort;
import com.example.cpf_validation.application.ports.out.FindAddressByZipCodeOutputPort;
import com.example.cpf_validation.application.ports.out.UpdateCustomerOutputPort;

@Configuration 
public class UpdateCustomerConfig {
    
    @Bean 
    public UpdateCustomerUseCase updateCustomerUseCase(
        FindCustomerByIdInputPort findCustomerByIdInputPort,
        FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
        UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeOutputPort, updateCustomerOutputPort);
    }

}

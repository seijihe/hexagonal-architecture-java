package com.example.cpf_validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.cpf_validation.adapters.out.FindAddressByZipCodeAdapter;
import com.example.cpf_validation.adapters.out.UpdateCustomerAdapter;
import com.example.cpf_validation.application.core.usecases.UpdateCustomerUseCase;
import com.example.cpf_validation.application.ports.in.FindCustomerByIdInputPort;


@Configuration 
public class UpdateCustomerConfig {
    
    @Bean 
    public UpdateCustomerUseCase updateCustomerUseCase(
        FindCustomerByIdInputPort findCustomerByIdInputPort,
        FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
        UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}

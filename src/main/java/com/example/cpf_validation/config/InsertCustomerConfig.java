package com.example.cpf_validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.cpf_validation.adapters.out.FindAddressByZipCodeAdapter;
import com.example.cpf_validation.adapters.out.InsertCustomerAdapter;
import com.example.cpf_validation.adapters.out.SendCpfValidationAdapter;
import com.example.cpf_validation.application.core.usecases.InsertCustomerUseCase;

@Configuration 
public class InsertCustomerConfig {
    
    @Bean 
    public InsertCustomerUseCase insertCustomerUseCase(
        FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
        InsertCustomerAdapter insertCustomerAdapter,
        SendCpfValidationAdapter sendCpfValidationAdapter
        
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }

}

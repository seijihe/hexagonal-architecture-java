package com.example.cpf_validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.cpf_validation.adapters.out.FindCustomerByIdAdapter;
import com.example.cpf_validation.application.core.usecases.FindCustomerByIdUseCase;


@Configuration 
public class FindCustomerByIdConfig {
    
    @Bean 
    public FindCustomerByIdUseCase findCustomerByIdConfig(
        FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }

}

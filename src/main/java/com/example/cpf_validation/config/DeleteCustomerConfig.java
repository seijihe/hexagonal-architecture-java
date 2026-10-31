package com.example.cpf_validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.cpf_validation.adapters.out.DeleteCustomerAdapter;
import com.example.cpf_validation.adapters.out.FindCustomerByIdAdapter;
import com.example.cpf_validation.application.core.usecases.DeleteCustomerByIdUseCase;


@Configuration 
public class DeleteCustomerConfig {
    
    @Bean 
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
        FindCustomerByIdAdapter findCustomerByIdAdapter,
        DeleteCustomerAdapter deleteCustomerAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdAdapter, deleteCustomerAdapter);
    }

}

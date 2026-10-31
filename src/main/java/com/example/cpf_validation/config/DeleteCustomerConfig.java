package com.example.cpf_validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.cpf_validation.application.core.usecases.DeleteCustomerByIdUseCase;
import com.example.cpf_validation.application.ports.out.DeleteCustomerByIdOutputPort;
import com.example.cpf_validation.application.ports.out.FindCustomerByIdOutputPort;

@Configuration 
public class DeleteCustomerConfig {
    
    @Bean 
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
        FindCustomerByIdOutputPort findCustomerByIdOutputPort,
        DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdOutputPort, deleteCustomerByIdOutputPort);
    }

}

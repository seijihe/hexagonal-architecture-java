package com.example.cpf_validation.application.core.usecases;

import com.example.cpf_validation.application.core.domain.Customer;
import com.example.cpf_validation.application.ports.in.FindCustomerByIdInputPort;
import com.example.cpf_validation.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort{
    
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(
        FindCustomerByIdOutputPort findCustomerByIdOutputPort
    ) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override 
    public Customer find(String id) {
        return findCustomerByIdOutputPort.find(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

}

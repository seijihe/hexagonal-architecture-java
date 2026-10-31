package com.example.cpf_validation.application.ports.out;

import com.example.cpf_validation.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    
    void update(Customer customer);
}

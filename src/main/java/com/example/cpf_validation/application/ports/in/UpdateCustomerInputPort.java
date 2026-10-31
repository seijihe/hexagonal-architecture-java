package com.example.cpf_validation.application.ports.in;

import com.example.cpf_validation.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    
    void update(Customer customer, String zipCode);
    
}

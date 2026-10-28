package com.example.cpf_validation.application.ports.in;

import com.example.cpf_validation.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    
    Customer find(String id);

}

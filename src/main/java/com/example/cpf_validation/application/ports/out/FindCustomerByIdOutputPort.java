package com.example.cpf_validation.application.ports.out;

import java.util.Optional;
import com.example.cpf_validation.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {
    
    /* 
        We're using Optional here because at calling inside "usecase" we'll only work
        with business rules, not with validation
    */

    Optional<Customer> find(String id);

}

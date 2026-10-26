package com.example.cpf_validation.application.ports.out;

import com.example.cpf_validation.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    
    Address find(String zipCode);

}

package com.example.cpf_validation.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import com.example.cpf_validation.adapters.out.client.response.AddressResponse;
import com.example.cpf_validation.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    
    Address toAddress(AddressResponse addressResponse);
    
}

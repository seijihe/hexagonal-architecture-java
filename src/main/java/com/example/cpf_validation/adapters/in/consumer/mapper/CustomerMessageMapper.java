package com.example.cpf_validation.adapters.in.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.cpf_validation.adapters.in.consumer.message.CustomerMessage;
import com.example.cpf_validation.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {
    
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage CustomerMessage);

}

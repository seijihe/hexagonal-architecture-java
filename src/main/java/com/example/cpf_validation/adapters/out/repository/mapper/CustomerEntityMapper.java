package com.example.cpf_validation.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import com.example.cpf_validation.adapters.out.repository.entity.CustomerEntity;
import com.example.cpf_validation.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    
    CustomerEntity toEntity(Customer customer);

}

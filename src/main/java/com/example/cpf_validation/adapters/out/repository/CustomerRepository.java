package com.example.cpf_validation.adapters.out.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cpf_validation.adapters.out.repository.entity.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    
}



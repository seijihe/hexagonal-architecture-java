package com.example.cpf_validation.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.cpf_validation.adapters.out.repository.CustomerRepository;
import com.example.cpf_validation.adapters.out.repository.mapper.CustomerEntityMapper;
import com.example.cpf_validation.application.core.domain.Customer;
import com.example.cpf_validation.application.ports.out.InsertCustomerOutputPort;

@Component 
public class InsertCustomerAdapter implements InsertCustomerOutputPort{

    @Autowired 
    private CustomerRepository customerRepository;

    @Autowired 
    private CustomerEntityMapper customerEntityMapper;

    public InsertCustomerAdapter(
        CustomerRepository customerRepository,
        CustomerEntityMapper customerEntityMapper
    ) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        customerRepository.save(customerEntityMapper.toEntity(customer));
    }
    
}

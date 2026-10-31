package com.example.cpf_validation.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.cpf_validation.adapters.out.repository.CustomerRepository;
import com.example.cpf_validation.adapters.out.repository.mapper.CustomerEntityMapper;
import com.example.cpf_validation.application.core.domain.Customer;
import com.example.cpf_validation.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerAdapter implements UpdateCustomerOutputPort{
    
    @Autowired 
    private CustomerRepository customerRepository;

    @Autowired 
    private CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(
        CustomerRepository customerRepository,
        CustomerEntityMapper customerEntityMapper
    ) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toEntity(customer);
        customerRepository.save(customerEntity);
    }

}

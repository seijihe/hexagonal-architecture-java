package com.example.cpf_validation.adapters.out;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.cpf_validation.adapters.out.repository.CustomerRepository;
import com.example.cpf_validation.adapters.out.repository.mapper.CustomerEntityMapper;
import com.example.cpf_validation.application.core.domain.Customer;
import com.example.cpf_validation.application.ports.out.FindCustomerByIdOutputPort;

@Component 
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired 
    private CustomerRepository customerRepository;

    @Autowired 
    private CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdAdapter(
        CustomerRepository customerRepository,
        CustomerEntityMapper customerEntityMapper
    ) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }


    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
    
}

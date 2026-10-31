package com.example.cpf_validation.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.cpf_validation.adapters.out.repository.CustomerRepository;
import com.example.cpf_validation.application.ports.out.DeleteCustomerByIdOutputPort;

@Component 
public class DeleteCustomerAdapter implements DeleteCustomerByIdOutputPort{

    @Autowired 
    private CustomerRepository customerRepository;

    public DeleteCustomerAdapter(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);;
    }
    
}

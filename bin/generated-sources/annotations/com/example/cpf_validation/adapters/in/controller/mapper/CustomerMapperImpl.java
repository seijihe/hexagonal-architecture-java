package com.example.cpf_validation.adapters.in.controller.mapper;

import com.example.cpf_validation.adapters.in.controller.request.CustomerRequest;
import com.example.cpf_validation.adapters.in.controller.response.AddressResponse;
import com.example.cpf_validation.adapters.in.controller.response.CustomerResponse;
import com.example.cpf_validation.application.core.domain.Address;
import com.example.cpf_validation.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-27T23:16:01-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.200.v20261008-1115, environment: Java 25.0.4.1 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerRequest.getName() );
        customer.setCpf( customerRequest.getCpf() );

        return customer;
    }

    @Override
    public CustomerResponse toCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setAddress( addressToAddressResponse( customer.getAddress() ) );
        customerResponse.setCpf( customer.getCpf() );
        customerResponse.setId( customer.getId() );
        customerResponse.setIsValidCpf( customer.getIsValidCpf() );
        customerResponse.setName( customer.getName() );

        return customerResponse;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setCity( address.getCity() );
        addressResponse.setState( address.getState() );
        addressResponse.setStreet( address.getStreet() );

        return addressResponse;
    }
}

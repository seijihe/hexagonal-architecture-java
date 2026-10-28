package com.example.cpf_validation.adapters.out.repository.mapper;

import com.example.cpf_validation.adapters.out.repository.entity.AddressEntity;
import com.example.cpf_validation.adapters.out.repository.entity.CustomerEntity;
import com.example.cpf_validation.application.core.domain.Address;
import com.example.cpf_validation.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-26T21:44:33-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.200.v20261008-1115, environment: Java 25.0.4.1 (Eclipse Adoptium)"
)
@Component
public class CustomerEntityMapperImpl implements CustomerEntityMapper {

    @Override
    public CustomerEntity toEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customer.getId() );
        customerEntity.setName( customer.getName() );
        customerEntity.setAddress( addressToAddressEntity( customer.getAddress() ) );
        customerEntity.setCpf( customer.getCpf() );
        customerEntity.setIsValidCpf( customer.getIsValidCpf() );

        return customerEntity;
    }

    @Override
    public Customer toCustomer(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerEntity.getId() );
        customer.setName( customerEntity.getName() );
        customer.setAddress( addressEntityToAddress( customerEntity.getAddress() ) );
        customer.setCpf( customerEntity.getCpf() );
        customer.setIsValidCpf( customerEntity.getIsValidCpf() );

        return customer;
    }

    protected AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setStreet( address.getStreet() );
        addressEntity.setCity( address.getCity() );
        addressEntity.setState( address.getState() );

        return addressEntity;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressEntity.getStreet() );
        address.setCity( addressEntity.getCity() );
        address.setState( addressEntity.getState() );

        return address;
    }
}

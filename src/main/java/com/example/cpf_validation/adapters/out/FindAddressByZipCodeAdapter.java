package com.example.cpf_validation.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.cpf_validation.adapters.out.client.FindAddressByZipCodeClient;
import com.example.cpf_validation.adapters.out.client.mapper.AddressResponseMapper;
import com.example.cpf_validation.adapters.out.client.response.AddressResponse;
import com.example.cpf_validation.application.core.domain.Address;
import com.example.cpf_validation.application.ports.out.FindAddressByZipCodeOutputPort;

@Component 
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired 
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired 
    private AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdapter(
        FindAddressByZipCodeClient findAddressByZipCodeClient,
        AddressResponseMapper addressResponseMapper
    ) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}

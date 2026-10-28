package com.example.cpf_validation.adapters.in.controller.response;

import lombok.Data;

@Data 
public class CustomerResponse {

    private String id;
    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isValidCpf;
    
}

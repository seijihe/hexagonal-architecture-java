package com.example.cpf_validation.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data 
public class CustomerRequest {
    
    @NotBlank // Cannot be null, "", " " 
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String zipCode;

}

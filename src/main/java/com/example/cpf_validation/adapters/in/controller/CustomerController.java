package com.example.cpf_validation.adapters.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cpf_validation.adapters.in.controller.mapper.CustomerMapper;
import com.example.cpf_validation.adapters.in.controller.request.CustomerRequest;
import com.example.cpf_validation.adapters.in.controller.response.CustomerResponse;
import com.example.cpf_validation.application.ports.in.FindCustomerByIdInputPort;
import com.example.cpf_validation.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api/v1/custommers")
public class CustomerController {

    @Autowired 
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired 
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired 
    private CustomerMapper customerMapper;

    public CustomerController(
        InsertCustomerInputPort insertCustomerInputPort,
        FindCustomerByIdInputPort findCustomerByIdInputPort,
        CustomerMapper customerMapper
    ) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.customerMapper = customerMapper;
    }

    /*
    @Valid instructs the framework to automatically evaluate all validation constraints 
    (like @NotNull, @NotBlank, or @Size) defined inside that object before executing the method.
    */
    
    @PostMapping("path")
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

        var custumer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(custumer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();

    }

    /* 
        That final inside the method param makes the variable immutable inside the method.
        That's make sense in our case, because means "Id come from the path, and should not 
        be modified".
    */
    @GetMapping("path")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok(customerResponse);

    }
    
    
}

package com.example.cpf_validation.adapters.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cpf_validation.adapters.in.controller.mapper.CustomerMapper;
import com.example.cpf_validation.adapters.in.controller.request.CustomerRequest;
import com.example.cpf_validation.adapters.in.controller.response.CustomerResponse;
import com.example.cpf_validation.application.core.domain.Customer;
import com.example.cpf_validation.application.ports.in.DeleteCustomerInputPort;
import com.example.cpf_validation.application.ports.in.FindCustomerByIdInputPort;
import com.example.cpf_validation.application.ports.in.InsertCustomerInputPort;
import com.example.cpf_validation.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController 
@RequestMapping("/api/v1/custommers")
public class CustomerController {

    /*
        At usecase classes doesn't use framework. For that reason they can be final.
        However here, marked with annotations (like @RestController), at @Autowired
        the bean is injected after the object creation. 
    */

    @Autowired 
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired 
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired 
    private UpdateCustomerInputPort updateCustomerInputPort; 

    @Autowired 
    private DeleteCustomerInputPort deleteCustomerInputPort;

    @Autowired 
    private CustomerMapper customerMapper;
    

    public CustomerController(
        InsertCustomerInputPort insertCustomerInputPort,
        FindCustomerByIdInputPort findCustomerByIdInputPort,
        UpdateCustomerInputPort updateCustomerInputPort,
        DeleteCustomerInputPort deleteCustomerInputPort,
        CustomerMapper customerMapper
    ) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.customerMapper = customerMapper;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.deleteCustomerInputPort = deleteCustomerInputPort;
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

    @PutMapping("path/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode()); // Eventhought zip code come from customer, we break in two parts thinking on inputs required to apply the method
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/path/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}

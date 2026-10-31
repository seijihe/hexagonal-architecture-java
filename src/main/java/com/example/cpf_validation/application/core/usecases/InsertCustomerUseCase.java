package com.example.cpf_validation.application.core.usecases;

import com.example.cpf_validation.application.core.domain.Customer;
import com.example.cpf_validation.application.ports.in.InsertCustomerInputPort;
import com.example.cpf_validation.application.ports.out.FindAddressByZipCodeOutputPort;
import com.example.cpf_validation.application.ports.out.InsertCustomerOutputPort;
import com.example.cpf_validation.application.ports.out.SendCpfForValidationOuputPort;

/*
    Since it's a /core code, we cannot use an spring @Autowired to inject our class
*/

public class InsertCustomerUseCase implements InsertCustomerInputPort{
    
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOuputPort sendCpfForValidationOuputPort;

    public InsertCustomerUseCase(
        FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
        InsertCustomerOutputPort insertCustomerOutputPort,
        SendCpfForValidationOuputPort sendCpfForValidationOuputPort
    ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOuputPort = sendCpfForValidationOuputPort;
    }

    @Override 
    public void insert(Customer customer, String zipCode) {

        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOuputPort.send(customer.getCpf());

    }

}

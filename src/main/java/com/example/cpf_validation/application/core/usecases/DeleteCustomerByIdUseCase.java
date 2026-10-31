package com.example.cpf_validation.application.core.usecases;

import com.example.cpf_validation.application.ports.in.DeleteCustomerInputPort;
import com.example.cpf_validation.application.ports.out.DeleteCustomerByIdOutputPort;
import com.example.cpf_validation.application.ports.out.FindCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerInputPort{
    
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(
        FindCustomerByIdOutputPort findCustomerByIdOutputPort,
        DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort
    ) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    public void delete(String id) {
        findCustomerByIdOutputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }

}

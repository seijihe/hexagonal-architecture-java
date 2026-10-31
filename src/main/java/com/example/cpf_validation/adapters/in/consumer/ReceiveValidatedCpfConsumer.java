package com.example.cpf_validation.adapters.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.cpf_validation.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.example.cpf_validation.adapters.in.consumer.message.CustomerMessage;
import com.example.cpf_validation.application.ports.in.UpdateCustomerInputPort;

@Component 
public class ReceiveValidatedCpfConsumer {
    
    @Autowired 
    private UpdateCustomerInputPort updateCustomerInputPort; 

    @Autowired 
    private CustomerMessageMapper customerMessageMapper;

    public ReceiveValidatedCpfConsumer(
        UpdateCustomerInputPort updateCustomerInputPort,
        CustomerMessageMapper customerMessageMapper
    ){
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.customerMessageMapper = customerMessageMapper;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "seijihe")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }

}

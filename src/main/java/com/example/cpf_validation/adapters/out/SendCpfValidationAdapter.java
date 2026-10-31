package com.example.cpf_validation.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.example.cpf_validation.application.ports.out.SendCpfForValidationOuputPort;


@Component 
public class SendCpfValidationAdapter implements SendCpfForValidationOuputPort{

    @Autowired 
    private KafkaTemplate<String, String> kafkaTemplate;

    public SendCpfValidationAdapter(
        KafkaTemplate<String, String> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String cpf) {
       kafkaTemplate.send("tp-cpf-validation", cpf);
    }
    

}

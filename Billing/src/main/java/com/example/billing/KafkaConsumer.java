package com.example.billing;

import com.example.billing.entities.Customer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = {"topicamine"},groupId = "enset_sii")
    public void onMessage(String message){
        System.out.println("Received:=>"+message);
    }
}

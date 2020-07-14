package com.noran.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.noran.demo.model.kafkaModels.Producer;
import com.noran.demo.service.KafkaConsumer;
import com.noran.demo.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer producer;
    @Autowired
    private KafkaConsumer consumer;

    KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public void send(@RequestBody Producer producer) {
        try {
            this.producer.sendMessage(producer);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}

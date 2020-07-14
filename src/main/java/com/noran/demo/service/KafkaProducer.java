package com.noran.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noran.demo.model.kafkaModels.Producer;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    private NewTopic topic;
    @Autowired
    ObjectMapper objectMapper;

    public void sendMessage(Producer producer) throws JsonProcessingException {

        String value = objectMapper.writeValueAsString(producer);
        logger.info(String.format("#### -> Producing message -> %s", value));
        this.kafkaTemplate.send(topic.name(), value);
    }
}

package com.noran.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.noran.demo.model.kafkaModels.Consumer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class KafkaConsumer {

    @Autowired
    org.apache.kafka.clients.consumer.Consumer consumer;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private NewTopic topic;

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "person", groupId = "1")
    public void consume() {
        ConsumerRecords poll = consumer.poll(Duration.ofSeconds(5));
        logger.info(String.format("#### -> Consumed message -> %s", poll.records("person")));
    }
}

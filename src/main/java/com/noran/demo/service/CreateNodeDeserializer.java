package com.noran.demo.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noran.demo.model.kafkaModels.Nodes;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public class CreateNodeDeserializer implements Deserializer {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        Nodes node = null;
        try {
            node = objectMapper.readValue(data, Nodes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

    @Override
    public Object deserialize(String topic, Headers headers, byte[] data) {
        return null;
    }

    @Override
    public void close() {

    }
}

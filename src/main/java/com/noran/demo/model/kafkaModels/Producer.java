package com.noran.demo.model.kafkaModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producer {
    private String id;
    private Map<String, String> properties;
}

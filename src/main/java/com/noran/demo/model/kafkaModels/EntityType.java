package com.noran.demo.model.kafkaModels;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EntityType {
    node("node"),
    relationship("relationship");

    private String value;
}

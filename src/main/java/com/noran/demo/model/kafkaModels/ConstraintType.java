package com.noran.demo.model.kafkaModels;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConstraintType {
    UNIQUE("UNIQUE"),
    NODE_PROPERTY_EXISTS("NODE_PROPERTY_EXISTS"),
    RELATIONSHIP_PROPERTY_EXISTS("RELATIONSHIP_PROPERTY_EXISTS");

    private String value;
}

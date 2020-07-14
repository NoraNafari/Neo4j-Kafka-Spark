package com.noran.demo.model.kafkaModels;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperationTypes {
    created("created"),
    updated("updated"),
    deleted("deleted");

    private String value;

}

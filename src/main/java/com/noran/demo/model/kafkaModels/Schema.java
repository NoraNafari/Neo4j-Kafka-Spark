package com.noran.demo.model.kafkaModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schema {
    private Constraints constraints;
    private Map properties;
}

package com.noran.demo.model.kafkaModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {
    private Meta meta;
    private Nodes nodes;
    private Payload payLoad;
}

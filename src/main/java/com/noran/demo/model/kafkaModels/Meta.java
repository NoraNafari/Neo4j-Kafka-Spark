package com.noran.demo.model.kafkaModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {
    private Integer timestamp;
    private String username;
    private Integer tx_id;
    private Integer tx_event_count;
    private OperationTypes operation;
    private Source source;
}

package com.noran.demo.model.kafkaModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payload {
    private Integer id;
    private EntityType type;
    private BeforeAfterNodes before;
    private BeforeAfterNodes after;
}

package com.noran.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeRequestDto {
    private String label;
    private String variable;
    private String variableType;
}

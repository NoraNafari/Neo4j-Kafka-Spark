package com.noran.demo.model.kafkaModels;

import org.apache.kafka.clients.consumer.Consumer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsumerCreateNode {
    ConsumerCreateNode INSTANCE = Mappers.getMapper(ConsumerCreateNode.class);
    Nodes consumerToNode(Consumer consumer);
}

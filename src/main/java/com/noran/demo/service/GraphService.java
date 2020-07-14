package com.noran.demo.service;

import com.noran.demo.model.NodeRequestDto;
import com.noran.demo.service.query.QueryBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GraphService {

    @Autowired
    DriverService driverService;
    @Autowired
    QueryBuilderService queryBuilderService;


    //Query Neo4j using its java driver
    public ResponseEntity getNodeWithId(Integer id){
        return driverService.returnResultWithHttp(queryBuilderService.nodeByIdSearch(String.valueOf(id)));
    }

    public ResponseEntity getRelationBetweenTwoNodes(NodeRequestDto firstNode, NodeRequestDto secondNode){
        return driverService.returnResultWithHttp(queryBuilderService.anyRelationSearch(firstNode, secondNode));
    }

    public ResponseEntity getRelationsWithLength(NodeRequestDto node, String length){
        return driverService.returnResultWithHttp(queryBuilderService.allRelationWithALength(node, Integer.valueOf(length)));
    }

    public ResponseEntity getRelationWithType(NodeRequestDto node, String type, String length){
        return driverService.returnResultWithHttp(queryBuilderService.relationWithType(node, type, Integer.valueOf(length)));
    }
}

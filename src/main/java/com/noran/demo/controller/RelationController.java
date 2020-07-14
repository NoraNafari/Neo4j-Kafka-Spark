package com.noran.demo.controller;

import com.noran.demo.model.NodeRequestDto;
import com.noran.demo.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relation")
public class RelationController {
    @Autowired
    GraphService graphService;

    @PostMapping
    public ResponseEntity getRelations(@RequestBody NodeRequestDto firstNode, NodeRequestDto secondNode) {
        return graphService.getRelationBetweenTwoNodes(firstNode, secondNode);
    }

    @PostMapping("/{length}")
    public ResponseEntity getRelationsWithLength(@RequestBody NodeRequestDto nodeRequestDto, @PathVariable String length){
        return graphService.getRelationsWithLength(nodeRequestDto, length);
    }

    @PostMapping("/{type}/{length}")
    public ResponseEntity getRelationWithLengthAndType(@RequestBody NodeRequestDto nodeRequestDto,
                                                       @PathVariable String length, @PathVariable String type) {
        return graphService.getRelationWithType(nodeRequestDto, type, length);
    }
}

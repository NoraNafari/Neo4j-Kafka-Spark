package com.noran.demo.controller;

import com.noran.demo.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    GraphService graphService;

    @PostMapping("{id}")
    public ResponseEntity getANode(@PathVariable Integer id){
        return graphService.getNodeWithId(id);
    }
}

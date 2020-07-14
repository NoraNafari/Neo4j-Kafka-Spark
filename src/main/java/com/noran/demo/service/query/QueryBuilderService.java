package com.noran.demo.service.query;

import com.noran.demo.model.NodeRequestDto;
import org.springframework.stereotype.Service;

@Service
public class QueryBuilderService {

    public String nodeByIdSearch(String id) {
        return "MATCH (n) WHERE id(n) = " + id + " RETURN n";
    }

    //Label: label of node: Movie, Person, etc
    //variableType:such as name, title, etc
    //variable: The amount of the certain variable: name of the actor, title of the movie, etc.
    //This will return any relationship between two nodes
    //added double quotations for string variables????
    public String anyRelationSearch(NodeRequestDto firstNode, NodeRequestDto secondNode) {
        return "MATCH (a:" + firstNode.getLabel() + "{" + firstNode.getVariableType() + " : " + "\""+ firstNode.getVariable() + "\"" +"})-[r]->" +
                "(b: " + secondNode.getLabel() + "{" + secondNode.getVariableType() + " : " + "\"" + secondNode.getVariable() + "\"" + "}) RETURN r ";
    }

    //Relations with a certain length for any node
    public String allRelationWithALength(NodeRequestDto node, Integer length) {
        return "MATCH (a:" + node.getLabel() + "{" + node.getVariableType() + " : " +"\"" + node.getVariable() + "\""+ "})-[*" + length + "]-(x)" + "RETURN x ";
    }

    //Relations with type
    public String relationWithType(NodeRequestDto node, String type, Integer length){
        return "MATCH (a:" +node.getLabel() + "{"+ node.getVariableType() + " : " +"\"" + node.getVariable() + "\""+ "})" +
                "CALL apoc.neighbors.athop(a," + "\"" + type + "\", " + length + ") YIELD node RETURN node";
    }
}

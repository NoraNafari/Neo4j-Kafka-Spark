package com.noran.demo.service;

import org.apache.spark.SparkContext;
import org.apache.spark.graphx.Graph;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;
import org.graphframes.GraphFrame;
import org.neo4j.spark.Neo4j;
import org.neo4j.spark.dataframe.Neo4jDataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.collection.immutable.Map$;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SparkWithNeo4jService {

    @Autowired
    SparkContext sparkContext;
    @Autowired
    ConversionUtils conversionUtils;

    public Neo4j runNeoInstance() {
        return new Neo4j(sparkContext);
    }

    //Query neo4j and convert the graph to graphFrame
    public void graphQuery() {
        GraphFrame graphFrame = runNeoInstance().nodes("match (n:Person) RETURN n.name as id", Map$.MODULE$.empty())
                .rels("match (p:Person)-[r]->(c:Movie) return p.name as src, c.title as dst, type(r) as value", Map$.MODULE$.empty())
                .loadGraphFrame(ClassTag.AnyVal(), ClassTag.AnyVal());
        GraphFrame run = graphFrame.pageRank().maxIter(1).run();
        run.vertices().show();
    }

}

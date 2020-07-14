package com.noran.demo;

import com.noran.demo.service.SparkWithNeo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphXWithNeo4jApplication implements CommandLineRunner {

    @Autowired
    SparkWithNeo4jService sparkWithNeo4jService;

    public static void main(String[] args) {
        SpringApplication.run(GraphXWithNeo4jApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        sparkWithNeo4jService.runNeoInstance();
        sparkWithNeo4jService.graphQuery();
    }
}

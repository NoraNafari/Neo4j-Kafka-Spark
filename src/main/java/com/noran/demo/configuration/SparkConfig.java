package com.noran.demo.configuration;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {
    @Bean
    JavaSparkContext config(){
        return JavaSparkContext.fromSparkContext(sparkContext());
    }

    @Bean
    SparkConf sparkConf(){
        return new SparkConf()
                .setAppName("graph")
                .setMaster("local[*]")
                .set("spark.neo4j.url","bolt://localhost:7687");
    }

    @Bean
    SparkContext sparkContext(){
        return new SparkContext(sparkConf());
    }

    @Bean
    SQLContext makeSQLContext(){
        return new SQLContext(config());
    }
}

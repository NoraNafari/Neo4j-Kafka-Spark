package com.noran.demo.service;

import org.springframework.stereotype.Service;
import scala.Tuple2;
import scala.collection.JavaConversions;
import scala.collection.Seq;
import scala.collection.immutable.Map$;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConversionUtils {

    public <T> scala.collection.immutable.Map javaMapToScalaMap(Map<T, T> map){
        List<Tuple2<T,T>> tuples = map.entrySet()
                .stream()
                .map(e -> Tuple2.apply(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        Seq<Tuple2<T,T>> seq = JavaConversions.asScalaBuffer(tuples).toSeq();
        return Map$.MODULE$.apply(seq);
    }
}

package com.noran.demo.service;

import com.noran.demo.model.QueryRequestDto;
import com.noran.demo.model.QueryStatementDto;
import org.neo4j.driver.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class DriverService {

    public TransactionConfig config(){
        return TransactionConfig.builder().build();
    }

    public Result instantiateDriver(String query){
        Driver driver = GraphDatabase.driver("bolt://localhost:7687");
        try (Session session = driver.session()){
            return session.run(query, config());
        }
    }

    public ResponseEntity<String> returnResultWithHttp(String query){
        QueryStatementDto queryStatementDto = new QueryStatementDto(query);
        QueryRequestDto queryRequestDto = new QueryRequestDto();
        ArrayList<QueryStatementDto> list = new ArrayList();
        list.add(queryStatementDto);
        queryRequestDto.setStatements(list);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));

        HttpEntity entity = new HttpEntity<>(queryRequestDto, headers);
       return restTemplate.postForEntity("http://localhost:7474/db/data/transaction/commit", entity, String.class);
    }
}

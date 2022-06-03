package com.mms.backend;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BackendApplicationTests {

    @LocalServerPort
    private int port;
    @Autowired
    private QueueController queueController;

    private TestRestTemplate testRestTemplate;


    void demo() {
        JSONObject request = new JSONObject();
//        request.put("Distribution", "EXPONENTIAL");
        request.put("s", "1");
        request.put("k", "3");
        request.put("lambda", "2");
        request.put("mu", "3");
        request.put("cw", "100");
        request.put("cs", "100");

        HttpEntity<String> httprequest = new HttpEntity<String>(request.toString());
        ResponseEntity<String> responsed = this.testRestTemplate.postForEntity("http://localhost:" + port + "/mmsk", httprequest, String.class);
        String response =  responsed.toString();
        assertTrue(response.contains("0.666"));
        assertTrue(response.contains("0.4308"));
        assertTrue(response.contains("1.0154"));
        assertTrue(response.contains("0.2456"));
        assertTrue(response.contains("0.5789"));
        assertTrue(response.contains("j143.0769"));
    }
}


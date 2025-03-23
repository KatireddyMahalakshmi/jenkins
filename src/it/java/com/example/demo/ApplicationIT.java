package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        // This test will fail if the application context cannot start
    }

    @Test
    public void testHelloEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }

    @Test
    public void testHelloNameEndpoint() {
        String name = "John";
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/hello/" + name, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello, John!");
    }

    @Test
    public void testHelloNameEndpointWithDifferentName() {
        String name = "Alice";
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/hello/" + name, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello, Alice!");
    }

}
package com.example.vkTest.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc
public class ProxyControllerTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ProxyController proxyController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPosts() {
        String expectedUrl = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<String> expectedResponseEntity = ResponseEntity.ok("Posts");

        when(restTemplate.getForEntity(expectedUrl, String.class)).thenReturn(expectedResponseEntity);

        ResponseEntity<String> actualResponseEntity = proxyController.getPosts(null);

    }

}

package com.example.vkTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.vkTest.audit.Audit;

@RestController
@RequestMapping("/api")
public class ProxyController {

    @Autowired
    private RestTemplate restTemplate;

    private final String JSON_URL = "https://jsonplaceholder.typicode.com";

    @Audit("get posts")
    @GetMapping("/posts/**")
    @PreAuthorize("hasAuthority('ROLE_POSTS') || hasAuthority('ROLE_POSTS_VIEWER')")
    public ResponseEntity<String> getPosts(@RequestParam(required = false) Integer userId) {
        String url = JSON_URL + "/posts";
        if (userId != null)
            url += "?userId=" + userId;
        return restTemplate.getForEntity(url, String.class);
    }

    @Audit("post posts")
    @PostMapping("/posts/**")
    @PreAuthorize("hasAuthority('ROLE_POSTS') || hasAuthority('ROLE_POSTS_EDITOR')")
    public ResponseEntity<String> createPost(@RequestBody String postJson) {
        String url = JSON_URL + "/posts";
        return restTemplate.postForEntity(url, postJson, String.class);
    }

    @PutMapping("/posts/{postId}")
    @PreAuthorize("hasAuthority('ROLE_POSTS') || hasAuthority('ROLE_POSTS_EDITOR')")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody String postJson) {
        String url = JSON_URL + "/posts/" + postId;

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(postJson),
                String.class);
        return response;
    }

    @DeleteMapping("/posts/{postId}")
    @PreAuthorize("hasAuthority('ROLE_POSTS') || hasAuthority('ROLE_POSTS_EDITOR')")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        String url = JSON_URL + "/posts/" + postId;
        restTemplate.delete(url);
        return ResponseEntity.noContent().build();
    }

    @Audit("get users")
    @GetMapping("/users/**")
    @PreAuthorize("hasAuthority('ROLE_USERS') || hasAuthority('ROLE_USERS_VIEWER')")
    public ResponseEntity<String> getUsers() {
        String url = JSON_URL + "/users";
        return restTemplate.getForEntity(url, String.class);
    }

    @PostMapping("/users/**")
    @PreAuthorize("hasAuthority('ROLE_USERS') || hasAuthority('ROLE_USERS_EDITOR')")
    public ResponseEntity<String> createUser(@RequestBody String postJson) {
        String url = JSON_URL + "/users";
        return restTemplate.postForEntity(url, postJson, String.class);
    }

    @PutMapping("/users/{userId}")
    @PreAuthorize("hasAuthority('ROLE_USERS') || hasAuthority('ROLE_USERS_EDITOR')")
    public ResponseEntity<String> updateUser(@PathVariable Long postId,
            @RequestBody String postJson) {
        String url = JSON_URL + "/users/" + postId;

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(postJson),
                String.class);
        return response;
    }

    @DeleteMapping("/users/{userId}")
    @PreAuthorize("hasAuthority('ROLE_USERS') || hasAuthority('ROLE_USERS_EDITOR')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long postId) {
        String url = JSON_URL + "/users/" + postId;
        restTemplate.delete(url);
        return ResponseEntity.noContent().build();
    }

    @Audit("get albums")
    @GetMapping("/albums/**")
    @PreAuthorize("hasAuthority('ROLE_ALBUMS') || hasAuthority('ROLE_ALBUMS_VIEWER')")
    public ResponseEntity<String> getAlbums() {
        String url = JSON_URL + "/albums";
        return restTemplate.getForEntity(url, String.class);
    }

    @PostMapping("/albums/**")
    @PreAuthorize("hasAuthority('ROLE_ALBUMS') || hasAuthority('ROLE_ALBUMS_EDITOR')")
    public ResponseEntity<String> createAlbums(@RequestBody String postJson) {
        String url = JSON_URL + "/albums";
        return restTemplate.postForEntity(url, postJson, String.class);
    }

    @PutMapping("/albums/{albumId}")
    @PreAuthorize("hasAuthority('ROLE_ALBUMS') || hasAuthority('ROLE_ALBUMS_EDITOR')")
    public ResponseEntity<String> updateAlbums(@PathVariable Long postId, @RequestBody String postJson) {
        String url = JSON_URL + "/albums/" + postId;

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(postJson),
                String.class);
        return response;
    }

    @DeleteMapping("/albums/{albumsId}")
    @PreAuthorize("hasAuthority('ROLE_ALBUMS') || hasAuthority('ROLE_ALBUMS_EDITOR')")
    public ResponseEntity<Void> deleteAlbums(@PathVariable Long postId) {
        String url = JSON_URL + "/albums/" + postId;
        restTemplate.delete(url);
        return ResponseEntity.noContent().build();
    }

}

package com.example.vkTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vkTest.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    List<User> findAll();

}

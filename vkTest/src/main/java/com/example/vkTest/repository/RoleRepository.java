package com.example.vkTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vkTest.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);

}

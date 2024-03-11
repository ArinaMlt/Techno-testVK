package com.example.vkTest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

}

package com.example.vkTest.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "audit_log")
public class AuditLog {
    @Id
    private String id;
    private String username;
    private LocalDateTime localDateTime;

}

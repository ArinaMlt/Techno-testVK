package com.example.vkTest.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "audit_logs")
public class AuditLog {
    @Id
    private String id;
    private String username;
    private String access;
    private String methodName;
    private String action;
    private String params;
    private LocalDateTime localDateTime;

}

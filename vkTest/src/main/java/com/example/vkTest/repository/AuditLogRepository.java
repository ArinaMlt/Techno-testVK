package com.example.vkTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.vkTest.model.AuditLog;

public interface AuditLogRepository extends MongoRepository<AuditLog, String> {

}

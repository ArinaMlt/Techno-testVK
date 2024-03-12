package com.example.vkTest.audit;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vkTest.model.AuditLog;
import com.example.vkTest.repository.AuditLogRepository;

@Service
public class AuditSevice {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void auditAction(String action, String username, String access, String methodName, String params) {
        System.out.println("Auditing action: " + action + ", Message: " + methodName);
        AuditLog log = new AuditLog();
        log.setUsername(username);
        log.setAccess(access);
        log.setAction(action);
        log.setParams(params);
        log.setLocalDateTime(LocalDateTime.now());
        auditLogRepository.save(log);
    }
}

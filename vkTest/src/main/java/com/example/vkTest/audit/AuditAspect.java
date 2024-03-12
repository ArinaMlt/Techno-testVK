package com.example.vkTest.audit;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditAspect {
    @Autowired
    private AuditSevice auditService;

    @AfterReturning(value = "@annotation(audit)", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Audit audit, Object returnValue) {
        String methodName = joinPoint.getSignature().getName();
        String username = getUsername();
        String access = checkAccess();
        String params = Arrays.toString(joinPoint.getArgs());
        auditService.auditAction(audit.value(), username, access, methodName, params);
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        return "Anonymous";
    }

    private String checkAccess() {
        // check доступ
        return "Has access";
    }

}

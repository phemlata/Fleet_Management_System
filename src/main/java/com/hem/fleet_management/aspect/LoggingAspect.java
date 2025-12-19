package com.hem.fleet_management.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    // Log before any Service method runs
    @Before("execution(* com.hem.fleet_management.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("👉 AUDIT LOG: Executing method: " + joinPoint.getSignature().getName());
    }

    // Log after any Service method finishes
    @AfterReturning("execution(* com.hem.fleet_management.service.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        logger.info("✅ AUDIT LOG: Completed method: " + joinPoint.getSignature().getName());
    }
}
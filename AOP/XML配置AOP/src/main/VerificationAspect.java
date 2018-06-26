package main;

import org.aspectj.lang.JoinPoint;

/**
 * 验证切面
 */
public class VerificationAspect {

    public void beforeMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("VerificationAspect 前置通知: " + name);
    }

}

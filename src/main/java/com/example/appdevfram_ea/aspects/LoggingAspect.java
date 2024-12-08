package com.example.appdevfram_ea.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.appdevfram_ea.services.HouseholdService.*(..))")
    public void beforeMethod() {
        System.out.println("Before method execution");
    }

    @After("execution(* com.example.appdevfram_ea.services.HouseholdService.*(..))")
    public void afterMethod() {
        System.out.println("After method execution");
    }
}

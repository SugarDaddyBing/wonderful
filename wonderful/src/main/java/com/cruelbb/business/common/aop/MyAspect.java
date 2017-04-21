package com.cruelbb.business.common.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.cruelbb.business.common.annotation.MyA;

@Aspect
@Component
public class MyAspect {

  @Pointcut("@annotation(com.cruelbb.business.common.annotation.MyA)")
  public void myPointCut() {

  }

  @AfterReturning("myPointCut()")
  public void myAdvice(JoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();

    MyA mya = method.getAnnotation(MyA.class);

    System.out.println(mya.value());
  }
}

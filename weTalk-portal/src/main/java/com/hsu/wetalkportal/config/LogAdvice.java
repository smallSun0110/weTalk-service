package com.hsu.wetalkportal.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//让spring进行扫描 一定要加
@Component
//告诉spring，这个一个切面类，里面可以定义切入点和通知
@Aspect
@Slf4j
public class LogAdvice {

    /**
     * 首先定义一个切点
     */
    @Pointcut("@annotation(OpLog)")
    public void printLog() {
    }

    @After("printLog()")
    public void after(JoinPoint joinPoint){
        try {
            //获取方法名称
            String methodName = joinPoint.getSignature().getName();
            //获取类名称
            String className = joinPoint.getSignature().getDeclaringTypeName();
            System.out.println("类名:"+className+" 方法名:"+methodName);
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature =(MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method =signature.getMethod();
            // 获取操作
            OpLog opLog =method.getAnnotation(OpLog.class);
            log.info("模块名称:[{}],类型:[{}],描述信息:[{}]",opLog.opModule(),opLog.operType(),opLog.operDesc());
            //执行连接点的方法
            try {
                ((ProceedingJoinPoint)joinPoint).proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();

        }
    }

}
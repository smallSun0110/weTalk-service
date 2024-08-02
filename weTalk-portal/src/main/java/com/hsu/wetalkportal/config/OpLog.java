package com.hsu.wetalkportal.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpLog {

    /**
     *
     * 操作模块
     */
    String opModule();

    /**
     *
     * 操作类型
     */
    String operType();

    /**
     *
     * 操作描述
     */
    String operDesc();
}
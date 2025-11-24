package com.lll.springframework.aop;

/**
 * @author lyf
 * @description
 * @date 2025/11/24 17:15
 **/
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}

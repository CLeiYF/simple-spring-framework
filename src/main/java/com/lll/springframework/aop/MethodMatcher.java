package com.lll.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author lyf
 * @description
 * @date 2025/11/24 17:16
 **/
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}

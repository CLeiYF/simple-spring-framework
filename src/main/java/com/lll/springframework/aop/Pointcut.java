package com.lll.springframework.aop;

/**
 * @author lyf
 * @description
 * @date 2025/11/24 17:16
 **/
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}

package com.lll.springframework.aop;

/**
 * @author lyf
 * @description
 * @date 2025/11/24 17:16
 **/
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}

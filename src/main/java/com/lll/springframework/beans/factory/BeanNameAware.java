package com.lll.springframework.beans.factory;

/**
 * @author lyf
 * @description
 * @date 2025/11/19 21:44
 **/
public interface BeanNameAware extends Aware {

    void setBeanName(String name);
}

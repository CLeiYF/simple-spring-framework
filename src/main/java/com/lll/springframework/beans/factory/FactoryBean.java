package com.lll.springframework.beans.factory;

/**
 * @author lyf
 * @description
 * @date 2025/11/19 22:15
 **/
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}

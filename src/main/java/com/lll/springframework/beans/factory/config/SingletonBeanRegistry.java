package com.lll.springframework.beans.factory.config;

/**
 * @author lyf
 * @description 单例注册接口定义和实现
 * @date 2025/11/11 17:33
 **/
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}

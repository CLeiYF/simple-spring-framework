package com.lll.springframework.beans.factory.config;

import com.lll.springframework.beans.BeansException;
import com.lll.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author lyf
 * @description
 * @date 2025/11/13 17:37
 **/
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}

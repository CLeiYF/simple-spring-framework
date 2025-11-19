package com.lll.springframework.beans.factory.config;

import com.lll.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author lyf
 * @description
 * @date 2025/11/12 13:38
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}

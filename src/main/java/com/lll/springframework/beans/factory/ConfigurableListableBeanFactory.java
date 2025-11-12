package com.lll.springframework.beans.factory;

import com.lll.springframework.beans.BeansException;
import com.lll.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.lll.springframework.beans.factory.config.BeanDefinition;
import com.lll.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author lyf
 * @description
 * @date 2025/11/12 13:40
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}

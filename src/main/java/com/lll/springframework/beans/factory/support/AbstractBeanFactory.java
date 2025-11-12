package com.lll.springframework.beans.factory.support;

import com.lll.springframework.beans.BeansException;
import com.lll.springframework.beans.factory.BeanFactory;
import com.lll.springframework.beans.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @author lyf
 * @description 抽象类定义模板方法
 * @date 2025/11/11 17:34
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(String beanName, final Object[] args) throws BeansException {
        Object bean = getSingleton(beanName);
        if (Objects.nonNull(bean)) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}

package com.lll.springframework.context.support;

import com.lll.springframework.beans.BeansException;
import com.lll.springframework.beans.factory.config.BeanPostProcessor;
import com.lll.springframework.context.ApplicationContext;
import com.lll.springframework.context.ApplicationContextAware;

/**
 * @author lyf
 * @description
 * @date 2025/11/19 21:45
 **/
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

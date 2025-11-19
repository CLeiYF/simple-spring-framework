package com.lll.springframework.test.common;

import com.lll.springframework.beans.BeansException;
import com.lll.springframework.beans.PropertyValue;
import com.lll.springframework.beans.PropertyValues;
import com.lll.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.lll.springframework.beans.factory.config.BeanDefinition;
import com.lll.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author lyf
 * @description
 * @date 2025/11/13 17:34
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：BBB"));
    }
}

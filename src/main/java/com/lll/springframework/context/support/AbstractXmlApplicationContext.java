package com.lll.springframework.context.support;

import com.lll.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.lll.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Objects;

/**
 * @author lyf
 * @description
 * @date 2025/11/13 17:33
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (Objects.nonNull(configLocations)) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}

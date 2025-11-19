package com.lll.springframework.context.support;

import com.lll.springframework.beans.BeansException;
import com.lll.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.lll.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author lyf
 * @description
 * @date 2025/11/13 17:32
 **/
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}

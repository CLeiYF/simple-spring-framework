package com.lll.springframework.beans.factory;

import com.lll.springframework.beans.BeansException;

/**
 * @author lyf
 * @description 实现此接口，既能感知到所属的 BeanFactory
 * @date 2025/11/19 21:42
 **/
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}

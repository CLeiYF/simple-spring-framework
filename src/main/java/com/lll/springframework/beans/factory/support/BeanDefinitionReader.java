package com.lll.springframework.beans.factory.support;

import com.lll.springframework.beans.BeansException;
import com.lll.springframework.core.io.Resource;
import com.lll.springframework.core.io.ResourceLoader;

/**
 * @author lyf
 * @description 定义读取接口
 * @date 2025/11/12 13:39
 **/
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}

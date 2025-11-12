package com.lll.springframework.beans.factory;

import com.lll.springframework.beans.BeansException;

/**
 * @author lyf
 * @description
 * @date 2025/11/11 17:32
 **/
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
}

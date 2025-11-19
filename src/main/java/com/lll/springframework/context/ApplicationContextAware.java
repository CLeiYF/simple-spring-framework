package com.lll.springframework.context;

import com.lll.springframework.beans.BeansException;

/**
 * @author lyf
 * @description
 * @date 2025/11/19 21:45
 **/
public interface ApplicationContextAware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}

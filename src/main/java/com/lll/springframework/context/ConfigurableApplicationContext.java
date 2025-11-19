package com.lll.springframework.context;

import com.lll.springframework.beans.BeansException;

/**
 * @author lyf
 * @description
 * @date 2025/11/13 17:32
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     */
    void refresh() throws BeansException;
}

package com.lll.springframework.beans.factory;

/**
 * @author lyf
 * @description
 * @date 2025/11/19 17:04
 **/
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}

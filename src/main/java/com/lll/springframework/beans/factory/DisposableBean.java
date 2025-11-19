package com.lll.springframework.beans.factory;

/**
 * @author lyf
 * @description
 * @date 2025/11/19 17:05
 **/
public interface DisposableBean {

    void destroy() throws Exception;
}

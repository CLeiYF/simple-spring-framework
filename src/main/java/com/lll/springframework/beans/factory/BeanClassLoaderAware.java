package com.lll.springframework.beans.factory;

/**
 * @author lyf
 * @description
 * @date 2025/11/19 21:41
 **/
public interface BeanClassLoaderAware {

    void setBeanClassLoader(ClassLoader classLoader);
}

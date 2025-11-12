package com.lll.springframework.beans.factory.config;

/**
 * @author lyf
 * @description
 * @date 2025/11/12 13:06
 **/
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}

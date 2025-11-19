package com.lll.springframework.test.bean;

import com.lll.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyf
 * @description
 * @date 2025/11/19 22:47
 **/
public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> {
            Map<String, String> hashMap = new HashMap<>();

            hashMap.put("10001", "zeus");
            hashMap.put("10002", "lei");
            hashMap.put("10003", "yf");

            return "你被代理了 " + method.getName() + ":" + hashMap.get(args[0].toString());
        });

        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

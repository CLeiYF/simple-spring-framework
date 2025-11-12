package com.lll.springframework.beans.factory.support;

import com.lll.springframework.beans.BeansException;
import com.lll.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @author lyf
 * @description Cglib 实例化
 * @date 2025/11/11 19:34
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        if (Objects.isNull(ctor)) {
            return enhancer.create();
        }

        return enhancer.create(ctor.getParameterTypes(), args);
    }
}

package com.lll.springframework.context.evnet;

import com.lll.springframework.beans.factory.BeanFactory;
import com.lll.springframework.context.ApplicationEvent;
import com.lll.springframework.context.ApplicationListener;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 15:48
 **/
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}

package com.lll.springframework.context.evnet;

import com.lll.springframework.context.ApplicationEvent;
import com.lll.springframework.context.ApplicationListener;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 15:51
 **/
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}

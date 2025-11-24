package com.lll.springframework.test.event;

import com.lll.springframework.context.ApplicationListener;
import com.lll.springframework.context.evnet.ContextRefreshedEvent;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 17:27
 **/
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + event.getClass().getName());
    }
}

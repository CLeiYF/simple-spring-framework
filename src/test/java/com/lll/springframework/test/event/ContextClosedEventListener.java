package com.lll.springframework.test.event;

import com.lll.springframework.context.ApplicationListener;
import com.lll.springframework.context.evnet.ContextClosedEvent;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 17:20
 **/
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + event.getClass().getName());
    }
}

package com.lll.springframework.test.event;

import com.lll.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 17:30
 **/
public class CustomerEventListener implements ApplicationListener<CustomerEvent> {

    @Override
    public void onApplicationEvent(CustomerEvent event) {
        System.out.println("收到：" + event.getSource() + "消息；时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}

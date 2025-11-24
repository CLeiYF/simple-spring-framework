package com.lll.springframework.context;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 15:52
 **/
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}

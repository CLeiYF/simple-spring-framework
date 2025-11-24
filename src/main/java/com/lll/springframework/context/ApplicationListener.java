package com.lll.springframework.context;

import java.util.EventListener;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 15:54
 **/
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}

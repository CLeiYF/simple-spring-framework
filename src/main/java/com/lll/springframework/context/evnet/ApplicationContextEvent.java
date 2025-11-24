package com.lll.springframework.context.evnet;

import com.lll.springframework.context.ApplicationContext;
import com.lll.springframework.context.ApplicationEvent;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 15:51
 **/
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}

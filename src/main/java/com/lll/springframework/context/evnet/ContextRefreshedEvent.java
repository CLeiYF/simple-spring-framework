package com.lll.springframework.context.evnet;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 15:48
 **/
public class ContextRefreshedEvent extends ApplicationContextEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}

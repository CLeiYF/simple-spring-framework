package com.lll.springframework.context;

import java.util.EventObject;

/**
 * @author lyf
 * @description
 * @date 2025/11/20 15:52
 **/
public class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}

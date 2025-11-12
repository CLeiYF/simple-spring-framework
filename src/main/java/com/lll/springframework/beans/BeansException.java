package com.lll.springframework.beans;

/**
 * @author lyf
 * @description
 * @date 2025/11/11 17:32
 **/
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}

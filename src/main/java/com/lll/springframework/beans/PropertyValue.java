package com.lll.springframework.beans;

/**
 * @author lyf
 * @description
 * @date 2025/11/12 13:06
 **/
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

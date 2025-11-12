package com.lll.springframework.core.io;

/**
 * @author lyf
 * @description 包装资源加载器
 * @date 2025/11/12 13:42
 **/
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}

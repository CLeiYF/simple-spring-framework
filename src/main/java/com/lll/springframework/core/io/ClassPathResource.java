package com.lll.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.lll.springframework.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author lyf
 * @description 资源加载
 * @date 2025/11/12 13:41
 **/
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = Objects.nonNull(classLoader) ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);

        if (Objects.isNull(is)) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }

        return is;
    }
}

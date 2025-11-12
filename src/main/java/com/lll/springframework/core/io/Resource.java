package com.lll.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lyf
 * @description
 * @date 2025/11/12 13:42
 **/
public interface Resource {

    InputStream getInputStream() throws IOException;
}

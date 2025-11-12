package com.lll.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyf
 * @description
 * @date 2025/11/12 13:07
 **/
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "zeus");
        hashMap.put("10002", "lei");
        hashMap.put("10003", "yf");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}

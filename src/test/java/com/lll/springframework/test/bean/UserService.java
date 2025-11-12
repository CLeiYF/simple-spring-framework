package com.lll.springframework.test.bean;

/**
 * @author lyf
 * @description
 * @date 2025/11/11 17:16
 **/
public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("查询用户信息 " + userDao.queryUserName(uId) );
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

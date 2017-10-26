package com.test;

/**
 * Created by zhaogang3 on 2017/8/24.
 */
public class UserInfo {

    private String userName;
    private int age;

    public UserInfo(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || (obj.getClass() != UserInfo.class))
            return false;

        UserInfo info = (UserInfo)obj;
        return userName.equals(info.getUserName());
    }
}

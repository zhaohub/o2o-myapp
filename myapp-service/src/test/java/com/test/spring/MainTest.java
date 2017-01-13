package com.test.spring;

/**
 * Created by zhaogang3 on 2016/9/14.
 */
public class MainTest {

    private String username;
    private String mail;

    public static void main(String[] args) {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void init() {
        System.out.println("com.test.spring.MainTest init.");
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
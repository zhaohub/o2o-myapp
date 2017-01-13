package com.test.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhaogang3 on 2016/9/14.
 */
public class MainTest {

    public static final Logger logger = LoggerFactory.getLogger(MainTest.class);

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
        System.out.println("com.test.spring.MainTest init executed.");
        logger.error("error log test");
        logger.info("info log test");
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
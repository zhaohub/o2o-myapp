package com.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaogang3 on 2016/9/18.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("hello")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response){
        LOGGER.info("TestController->test");

        System.out.println(request.getParameter("hello"));


        return "TestController";
    }


}

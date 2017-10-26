package com.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ConfigurableObjectInputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaogang3 on 2016/9/18.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("hello")
    @ResponseBody
    public Map<String, Object> test(HttpServletRequest request, HttpServletResponse response){
        LOGGER.info("TestController->test");
        //response.setCharacterEncoding("utf-8");
        System.out.println(request.getParameter("hello"));
        String s = "{\"type\":\"0\",\"code\":\"redirect\",\"msg\":\"重定向\",\"result\":\"https://baidu.com\",\"detail\":\"\",\"success\":false}";


        Map<String,Object> map = new HashMap<String, Object>();
        map.put("type",0);
        map.put("code","redirect");
        map.put("msg","重定向");

        response.addHeader("Set-Cookie","PDJ_H5_MOBILE123=152****4045; Version=1; Max-Age=86400; Expires=Tue, 01-Aug-2017 09:28:44 GMT; Path=/");

        try {
            response.sendRedirect("http://www.126.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


}

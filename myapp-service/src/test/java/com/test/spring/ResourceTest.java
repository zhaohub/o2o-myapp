package com.test.spring;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhaogang3 on 2017/1/17.
 */
public class ResourceTest {

    public static void main(String[] args) throws IOException {
        /*Resource resource = new ByteArrayResource("hello spring".getBytes());
        if (resource.exists()) {
            dumpStream(resource);
        }*/

        /*ByteArrayInputStream bis = new ByteArrayInputStream("hello input stream".getBytes());
        Resource resource = new InputStreamResource(bis);*/

        Resource resource = new ClassPathResource("com/mysql/jdbc/Charsets.properties");
        if (resource.exists()) {
            dumpStream(resource);
        }

        System.out.println(resource.getURL());
        System.out.println(resource.isOpen());

    }

    public static void dumpStream(Resource resource) {
        InputStream is = null;

        try {
            is = resource.getInputStream();
            byte[] descBytes = new byte[is.available()];
            is.read(descBytes);
            System.out.println(new String(descBytes));
        } catch (Exception e) {

        } finally {
            try {
                is.close();
            } catch (Exception e) {

            }
        }
    }
}

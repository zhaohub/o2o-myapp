package com.test.logback;

import com.test.util.LogLevelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhaogang3 on 2016/9/8.
 */
public class LogbackTest {
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);


    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            Thread.sleep(100);
            logger.info("info");
            logger.debug("debug");
            logger.error("error");
            LogLevelUtil.changeLogLevel("info");
        }
    }
}

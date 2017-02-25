package com.test.util;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 动态修改日志级别
 * Created by zhaogang3 on 2017/2/24.
 */
public class LogLevelUtil {

    public static void changeLogLevel(String level) {
        if (level == null || level.length() == 0) return;

        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        List<Logger> loggerList = context.getLoggerList();

        Level lv;

        if (level.toLowerCase().equals("info")) {
            lv = Level.INFO;
        } else {
            lv = Level.ERROR;
        }
        for (Logger logger : loggerList) {
            logger.setLevel(lv);
        }

        context.reset();
    }
}

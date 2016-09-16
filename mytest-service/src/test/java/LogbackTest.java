import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by zhaogang3 on 2016/9/8.
 */
public class LogbackTest {
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);


    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            Thread.sleep(1000);
            logger.info("hello {}", new Date());
            logger.debug("11111111");
        }
    }
}

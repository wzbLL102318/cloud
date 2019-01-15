package com.scwl.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudApplicationTests {

    /**
     * slf4j2日志
     */

    public static Logger logger = LoggerFactory.getLogger(CloudApplicationTests.class);

    @Test
    public void contextLoads() {
        String str = "hello world";
        logger.info("XXXXXXXXXX : {}",str);
    }

}
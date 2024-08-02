package com.hsu.wetalkportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeTalkPortalApplication {

    private static final Logger log = LoggerFactory.getLogger(WeTalkPortalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WeTalkPortalApplication.class, args);
        log.info("weTalk-门户服务端启动成功");
    }

}

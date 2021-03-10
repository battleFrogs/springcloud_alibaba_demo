package com.gjc.nacosconfig.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope  //打开动态刷新功能
@RestController
public class TestController {


    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

    public Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test")
    public void test() {

        log.info("userName: {} ,age : {}", userName, age);

    }


}

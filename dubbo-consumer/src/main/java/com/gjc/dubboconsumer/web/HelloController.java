package com.gjc.dubboconsumer.web;

import com.gjc.dubboapi.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Reference(retries = 0, check = false)
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.hello("dubbo");
    }



}

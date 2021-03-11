package com.gjc.dubboprovider.service;

import com.gjc.dubboapi.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}

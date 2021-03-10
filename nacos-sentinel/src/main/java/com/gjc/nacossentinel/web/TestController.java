package com.gjc.nacossentinel.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.gjc.nacossentinel.utils.ExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {


    // 如果需要对某个特定的方法进行限流或降级，可以通过 @SentinelResource 注解来完成限流的埋点
    // 可以在 配置自定义限流规则(@SentinelResource埋点) ，配置注解上的value值
    @SentinelResource("resource")
    @RequestMapping("/hello")
    public Map<String, Object> hello(String appName) {
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("appName", appName);
        map.put("method", "hello");
        return map;
    }

    /**
     * 注解使用：
     * 1.value：资源名称，必需项（不能为空）
     * 2.entryType：入口类型，可选项（默认为 EntryType.OUT）
     * 3.blockHandler：blockHandlerClass中对应的异常处理方法名。参数类型和返回值必须和原方法一致
     * 4.blockHandlerClass：自定义限流逻辑处理类
     *
     * @return
     */
    //通过注解限流并自定义限流逻辑
    @SentinelResource(value = "resource2", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    @RequestMapping("/sentinel/test2")
    public Map<String, Object> test2() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("method", "test2");
        map.put("msg", "自定义限流逻辑处理");
        return map;
    }

    // 可以在控制台配置流控规则，争对具体的路径
    @RequestMapping("/sentinel/test")
    public Map<String, Object> test(String appName) {
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("appName", appName);
        map.put("method", "test");
        return map;
    }
}

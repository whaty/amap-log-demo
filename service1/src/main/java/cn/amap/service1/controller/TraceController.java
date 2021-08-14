package cn.amap.service1.controller;

import cn.amap.service1.service.RemoteBaseService;
import cn.amap.service1.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 狮少
 * @version 1.0
 * @date 2021/6/30
 * @describtion TraceCtoller
 * @since 1.0
 */
@Slf4j
@RequestMapping
@RestController
public class TraceController {
    @Autowired
    private OkHttpUtil okHttpUtil;
    @Autowired
    private RemoteBaseService remoteBaseService;

    @PostMapping("/service1")
    public String service(@RequestBody Map map) {
        log.info("service1 开始执行");
        log.info("service1 执行完毕");
        return "service1";
    }

    @PostMapping("/service2")
    public String getResultOfService2() {
        log.info("service1 开始调用service2");
        String resultOfService2 = remoteBaseService.getResultOfService2();
        log.info("service1 调用service2 结束");
        return resultOfService2;
    }
}

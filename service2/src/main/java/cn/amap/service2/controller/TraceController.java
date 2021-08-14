package cn.amap.service2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/service2")
    public String service() {
        log.info("service2 开始执行");
        log.info("service2 执行完毕");
        return "service2";
    }
}

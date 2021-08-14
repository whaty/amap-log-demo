package cn.amap.service1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author 狮少
 * @version 1.0
 * @date 2021/6/30
 * @describtion FeignClient
 * @since 1.0
 */
@FeignClient(name = "service2", url = "http://127.0.0.1:8081")
public interface RemoteBaseService {
    /**
     * 调用service2
     *
     * @param map
     * @return String
     */
    @PostMapping(value = "/service2")
    String getResultOfService2();
}

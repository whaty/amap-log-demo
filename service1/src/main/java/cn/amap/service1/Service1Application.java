package cn.amap.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 狮少
 * @version 1.0
 * @date 2021/6/30
 * @describtion Service1Application
 * @since 1.0
 */
@EnableFeignClients(basePackages = "cn.amap.service1.service")
@SpringBootApplication
public class Service1Application {
    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }
}

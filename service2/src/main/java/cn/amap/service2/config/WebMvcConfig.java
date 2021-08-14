package cn.amap.service2.config;

import cn.amap.common.config.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 狮少
 * @version 1.0
 * @date 2021/6/30
 * @describtion WebMvcConfig
 * @since 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 处理所有请求，该拦截器最先被执行
         */
        registry.addInterceptor(new LogInterceptor());

    }
}

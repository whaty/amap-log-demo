package cn.amap.common.config;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    private final static String HEADER = "header";
    private final static String TRACEID = "traceId";
    private final static String URI = "uri";
    private final static String DEVICEID = "deviceId";
    private final static String TOKEN = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.debug("add mdc");
        Map<String, Object> headerMap = new HashMap<>();
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String key = headers.nextElement();
            headerMap.put(key, request.getHeader(key));
        }
        MDC.put(HEADER, JSONUtil.toJsonStr(headerMap));
        MDC.put(URI, request.getRequestURI());
        MDC.put(TRACEID, request.getHeader(TRACEID));
        MDC.put(DEVICEID, request.getHeader(DEVICEID));
        MDC.put(TOKEN, request.getHeader(TOKEN));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.debug("remove mdc");
        MDC.remove(HEADER);
        MDC.remove(URI);
        MDC.remove(TRACEID);
        MDC.remove(DEVICEID);
        MDC.remove(TOKEN);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}

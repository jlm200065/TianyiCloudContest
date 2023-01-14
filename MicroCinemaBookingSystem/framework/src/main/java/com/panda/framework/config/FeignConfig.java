package com.panda.framework.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


//不管用，jwt没法传递，先放这了，把这一块的shiro放开了
@Configuration
public class FeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes != null){
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            String authorization = request.getHeader("Authorization");
            template.header("Authorization", authorization);
        }
    }
}


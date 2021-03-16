package com.cll.admin.config;

import com.cll.admin.component.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 跨域支持
     * @param registry
     */
    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
                .allowedOrigins("*")//允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
                .allowCredentials(true)//响应头表示是否可以将对请求的响应暴露给页面。返回true则可以，其他值均不可以
                .allowedMethods("GET", "POST", "DELETE", "PUT")//允许输入参数的请求方法访问该跨域资源服务器，如：POST、GET、PUT、OPTIONS、DELETE等。
                .allowedHeaders("*")//允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
                .maxAge(3600 * 24);//配置客户端缓存预检请求的响应的时间（以秒为单位）。默认设置为1800秒（30分钟）。
    }*/
}

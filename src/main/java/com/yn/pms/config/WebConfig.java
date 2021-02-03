package com.yn.pms.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.yn.pms.Intercepter.LoginIntercepter;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/27-12:02
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建一个转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //创建转换器配置
        FastJsonConfig config = new FastJsonConfig();
        //配置转换规则
        config.setSerializerFeatures(
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect
        );
        //指定转换器配置
        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        //将转换器添加到集合中
        converters.add(fastJsonHttpMessageConverter);


    }

    /**
     * 配置静态资源文件可以在外部直接访问
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/**");
    }

    /**
     * 配置让templates目录下的login.html页面可以通过url地址在浏览器直接访问
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置让templates目录下的login.html页面可以通过url地址在浏览器直接访问
        registry.addViewController("/login.html");
        //配置让templates目录下的home.html页面可以通过url地址在浏览器直接访问
        registry.addViewController("/home.html");
        registry.addViewController("/userpages/add_user.html");
        registry.addViewController("/tenants/*.html");
        registry.addViewController("/addcommunityinfo/*.html");
        registry.addViewController("/res/*.html");

    }

    @Bean
    public LoginIntercepter getLoginIntercpter(){
        return new LoginIntercepter();
    }

    /**
     * 配置我们自定义的拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginIntercpter()).addPathPatterns("/home.html");
    }

}

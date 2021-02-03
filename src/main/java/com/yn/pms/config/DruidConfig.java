package com.yn.pms.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yn
 * @class springbootProject
 * @describe
 * @date 2021/1/26-9:51
 */
@Configuration
public class DruidConfig {//druid实现性能监控的配置类

    /**
     * 该方法可以返回一个初始化了上下文（指定一些初始化参数）的servlet，
     * 相当于在web容器中注册添加了一个性能监控管理的servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //添加白名单（允许访问指定路径的ip）
        bean.addInitParameter("allow", "127.0.0.1,192.168.217.1");
        //黑名单
        bean.addInitParameter("deny", "192.168.217.2");
        //登录名称
        bean.addInitParameter("loginUsername", "yn");
        //登录密码
        bean.addInitParameter("loginPassword", "123456");
        //表示不能重置数据源
        bean.addInitParameter("resetEnable", "false");
        return bean;
    }


    /**
     * 该方法向web容器中注册了一个过滤器，该过滤器专门负责请求的性能监控统计
     * 并且给过滤器指定要拦截的路径和放行的路径（初始化）
     * @return
     */
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        //指定过滤器要拦截的路径
        filter.addUrlPatterns("/*");
        //指定过滤器要放行的路径
        filter.addInitParameter("exclusions","*.jpg,*.png,*.js,*.css,*.ico,*.gif,/druid/*");
        //指定处理给路径的过滤器
        filter.setFilter(new WebStatFilter());
        return filter;
    }

    /**
     * 需要用到连接池的配置信息
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource(){
        return new DruidDataSource();
    }


    /*------------------------以下方法是对监控spring的配置------------------------------*/

    /**
     * 该方法是向spring中注册一个负责监控统计方法性能的对象
     * 这个对象就类似之前做日志处理的切面类对象
     * @return
     */
    @Bean
    public DruidStatInterceptor getDruidStatInterceptor(){
        return new DruidStatInterceptor();
    }


    /**
     * 该方法是向spring容器中注入一个可以表示监控性能的切点对象
     * 换句话说就是将要监控的切点封装到了JdkRegexpMethodPointcut类对象中
     * @return
     */
    @Bean
    public JdkRegexpMethodPointcut getMethodPointcut(){
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        //设置切点
        pointcut.setPattern("com.yn.thymeleafdemo.service.impl.*");
        return pointcut;
    }

    /**
     * 该方法的作用是将要监控的切点交给指定的切面处理
     * 相当于起到了切点和切面的枢纽配置作用
     * @param interceptor
     * @param pointcut
     * @return
     */
    @Bean
    public DefaultPointcutAdvisor getDefaultPointcutAdvisor(DruidStatInterceptor interceptor, JdkRegexpMethodPointcut pointcut){
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut); //注入切点
        advisor.setAdvice(interceptor);//注入切面
        return advisor;
    }




















}

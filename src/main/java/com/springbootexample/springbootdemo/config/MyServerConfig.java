package com.springbootexample.springbootdemo.config;

import com.springbootexample.springbootdemo.Listener.MyListener;
import com.springbootexample.springbootdemo.filter.MyFilter;
import com.springbootexample.springbootdemo.servlet.Myservlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {
    /*
    编码方式修改servlet相关配置
    也可以在配置文件中配置
    其他的配置也可按照此方法
     */
//    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>(){

            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8080);
            }
        };
    }

    /*
    注册三大组件
    由于springboot使用jar包方式启动嵌入式的servlet容器来启动Springboot的外部应用，
    没有web.xml文件，注册三大组件使用以下方式
    1.注册一个servlet
    */
//    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new Myservlet());
        //设置返回顺序等
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
    /*
     2.例子二，注册Filter
     */
//    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    /*
    3.例子三，注册监听器
     */
//    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> myListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return myListenerServletListenerRegistrationBean;
    }
}

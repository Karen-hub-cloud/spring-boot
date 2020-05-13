package com.springbootexample.springbootdemo.config;

import com.springbootexample.springbootdemo.componet.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//extend WebMvcConfigurerAdapter-->已经不用了，换成了implements WebMvcConfigurer
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/springbootdemo请求，来到success
        registry.addViewController("/springbootdemo").setViewName("success");
    }


    //所有的WebMVCConfigerAdapter组件都会一起起作用。
    //@Bean：Springboot需要知道这个组件的存在。
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        //ctrl+o:select methods to  override or implements
        //匿名内部类
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            /*
            注册视图映射
             */
            public void addViewControllers(ViewControllerRegistry registry){
                //添加视图映射
                //发送请求，跳转到的是模板引擎中的login
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/index.html").setViewName("login");
            }

            /*
            注册拦截器
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //处理登录拦截器
                //双星是拦截任意路径下的任何请求
                //exclude排除一些请求，例如登录页面，/，登录请求
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login");
                //静态资源.css等，已经做好了静态资源映射，我们不用管，是可以正常访问的
            }
        };

        return webMvcConfigurer;
    }

    //把自定义的MyLocalResolver添到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

}

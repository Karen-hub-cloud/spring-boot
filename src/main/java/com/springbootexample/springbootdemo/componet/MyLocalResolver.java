package com.springbootexample.springbootdemo.componet;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
/*
实现效果：点击连接，切换国际化的区域信息
logi.html中加入链接
自己写一个区域信息解析器
实现LocaleResolver，这个是在自动配置类里
还需要加载容器里:实现：MyMvcConfig
 */
public class MyLocalResolver  implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求头参数为l的信息
        String l = request.getParameter("l");
        System.out.println("l:"+l);
        //没带参数，获取系统默认的
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            //截取一下字符串
            String[] split = l.split("_");
            //分别
            locale = new Locale(split[0], split[1]);
        }
        System.out.println("locale:"+locale);
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

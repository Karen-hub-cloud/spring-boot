package com.springbootexample.springbootdemo.controller;

import com.springbootexample.springbootdemo.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/*
异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {

//    1.写法一：浏览器客户端返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }


//    @ExceptionHandler({UserNotExistException.class})
//    public String handleException(Exception e, HttpServletRequest request){
////        此时会发现，status是200，转台信息都拿到了，但是没有跳转到错误页面
////        解决：在这里修改原生的状态码，引入request
//        request.setAttribute("javax.servlet.error.status_code",500);
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
////        转发到error
//        return "forward:/error";
//    }

//    携带出去定制数据
        @ExceptionHandler({UserNotExistException.class})
    public String handleException(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map = new HashMap<>();
//        异常处理器额外带了字段
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);

        return "forward:/error";
    }
}

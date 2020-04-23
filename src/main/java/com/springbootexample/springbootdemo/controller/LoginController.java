package com.springbootexample.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    /*
    这种RequestMapping有点复杂，可以使用PostMapping
     */
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String passeord,
                        Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username)&&passeord.equals("123456")){
            //登陆成功后，防止表单重复提交，【重定向】到主页,主页又加了视图映射
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
//            return "dashboard";
        }else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}

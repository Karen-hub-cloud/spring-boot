package com.springbootexample.springbootdemo.controller;

import com.springbootexample.springbootdemo.exception.UserNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class HelloController {
    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @Value("${person.last-name}")
    private String name;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/sayHello")
    public String sayHello(){

        return "Hello"+name;
    }
    @ResponseBody
    @RequestMapping("/testLog")
    public void testLog(){
        LOGGER.info("输出日志");
        //日志的级别；
        //由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        LOGGER.trace("这是trace日志...");
        LOGGER.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        LOGGER.info("这是info日志...");
        LOGGER.warn("这是warn日志...");
        LOGGER.error("这是error日志...");
    }


    //注意不要同名
    //@RequestMapping("/success")
    @RequestMapping("/getsuccess")
    public String success(){
        //跳转到classpath:/templates/success.html，无需任何配置
        //跳转页面没有@ResponseBody，要不然就成了返回success字符串了
        return "success";
    }
    @RequestMapping("/select")
    public String select(Map<String, Object> map){
        //跳转到classpath:/templates/success.html，无需任何配置
        //跳转页面没有@ResponseBody，要不然就成了返回success字符串了
        map.put("hello","<h1>你好</h>");
//        map.put("user", Arrays.asList("张三","里斯","王五"));

        return "success";
    }

    @RequestMapping("/geterror")
    public String geterror(Model model){
        return "error";
    }



    //可用MyMvcConfig中的webMvcConfigurer方法代替映射
    //这里的index是模板引擎下的，不是静态资源下的
    //如果不写这个映射，默认是访问静态资源下的
//    @RequestMapping({"/main.html"})
//    public String login(){
    //classpath:/templates/xxxx.html
//        return "dashboard";
//    }


    @ResponseBody
    @RequestMapping("/exception")
    public String testException(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "helloword";
    }

    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department");
        System.out.println(maps);
        return  maps.get(0);
    }

}

package com.springbootexample.springbootdemo.controller;

import com.springbootexample.springbootdemo.entities.Em;
import com.springbootexample.springbootdemo.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmController {
    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "按照id查找employee数据", notes = "/emp/{id}接口")
    @GetMapping("/em/{id}")
    public Em getemByid(@PathVariable("id") Integer id){
        return employeeService.getEmp(id);
    }

    @ApiOperation(value = "更新employee数据", notes = "/emp")
    @PutMapping("/em")
    public Em update(Em em){
        System.out.println("更新："+em);
        return employeeService.updateEmp(em);
    }

    @ApiOperation(value = "删除employee数据", notes = "/emp")
    @DeleteMapping("/em")
    public void deleteEm(Integer id){
         employeeService.deleteEmp(id);
    }

    @ApiOperation(value = "按照名字查找employee数据", notes = "/emp")
    @GetMapping("/em")
    public Em getemByid(String lastName){
        return employeeService.getEm(lastName);
    }

}

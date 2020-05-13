package com.springbootexample.springbootdemo.controller;

import com.springbootexample.springbootdemo.dao.DepartmentDao;
import com.springbootexample.springbootdemo.dao.EmployeeDao;
import com.springbootexample.springbootdemo.entities.Department;
import com.springbootexample.springbootdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController  {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        ///放在请求域中？
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //先查出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //返回到添加页面
        return "emp/add";
    }

    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定-->要求：请求参数的名字和JavaBean的入参对象的属性名一样
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        //redirect:重定向
        //forward:转发
        //以上两种方法才是转发到真正的请求，而不是模板引擎的页面,创建的是重定向视图，通过渲染？
        //
        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        System.out.println("id:"+id);
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //页面显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //这里懒省事了，用add页面代替editPage
        return "emp/add";
    }

    //需要提交员工id
    @PutMapping("/emp")
    public String upadteEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //不知道为什么，deleteMapping映射不成功
    //听说再配置里加上springboot.mvc.hiddenmethod.filter.enable = true就可以了
    @DeleteMapping("/emp/{id}")
//    @PostMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        System.out.println("进入删除");
        System.out.println("id:"+id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}

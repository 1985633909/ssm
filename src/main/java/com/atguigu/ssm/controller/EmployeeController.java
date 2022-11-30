package com.atguigu.ssm.controller;


import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * @author 19856
 * @creator 2022/10/18-16:32
 * 实现查询所有用户信息   /employee-->get
 * 实现查询用户分页信息   /employee/page/1 -->get
 * 添加用户信息 /employee -->post
 * 修改用户信息  /employee  -->put
 * 删除用户信息 /employee -->delete
 */
@Controller
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/page/1";

    }

    @RequestMapping(value = "employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);

        return "redirect:/employee/page/1";
    }

    @RequestMapping(value = "employee/{id}",method = RequestMethod.GET)
    public String ToUpdate(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @RequestMapping(value = "employee",method = RequestMethod.PUT)
    public String UpdateEmployee(Employee employee){
        employeeService.update(employee);
        return "redirect:/employee/page/1";
    }

    //获取员工分页信息
    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum")Integer pageNum,Model model){
        //获取员工分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //将分页数据共享到请求域中
        model.addAttribute("page",page);

        return "employee_list";
    }


    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //共享到请求域中
        model.addAttribute("list",list);
        //跳转到employee_list.html
        return "employee_list";
    }

}

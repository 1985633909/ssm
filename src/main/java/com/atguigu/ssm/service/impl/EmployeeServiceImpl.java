package com.atguigu.ssm.service.impl;


import com.atguigu.ssm.mapper.EmployeeMapper;
import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 19856
 * @creator 2022/10/18-18:04
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> list = employeeMapper.getAllEmployee();
        return list;
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,4);
        //查询所有员工的分页信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据  第一个参数，信息  第二个参数 导航分页的页数
        PageInfo<Employee> page = new PageInfo<>(list,5);
        return page;
    }

    @Override
    public Employee getEmployeeById(Integer EmpId) {
        Employee employee = employeeMapper.getEmployeeById(EmpId);
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deleteEmployee(id);
    }

}

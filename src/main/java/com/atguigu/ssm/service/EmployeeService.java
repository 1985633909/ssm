package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 19856
 * @creator 2022/10/18-18:04
 */

public interface EmployeeService {

    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);

    Employee getEmployeeById(Integer EmpId);

    void addEmployee(Employee employee);

    void update(Employee employee);

    void deleteEmployee(Integer id);

    //void UpdateEmployee();
}

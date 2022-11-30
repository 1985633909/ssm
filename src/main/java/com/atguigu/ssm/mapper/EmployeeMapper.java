package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 19856
 * @creator 2022/10/18-18:20
 */
public interface EmployeeMapper {


    List<Employee> getAllEmployee();

    Employee getEmployeeById(@Param("empId") Integer empId);

    int addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(@Param("empId") Integer id);
}

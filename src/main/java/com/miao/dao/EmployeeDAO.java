package com.miao.dao;

import com.miao.bean.Employee;

import java.util.List;

/**
 * Created by 10048 on 2017/5/9.
 */
public interface EmployeeDAO {
    /**
     * 添加员工信息
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 删除员工信息
     * @param employeeId
     */
    void deleteEmployee(int employeeId);

    /**
     * 查询所有员工信息
     * @return
     */
    List<Employee> findAllEmployee();

    /**
     * 按照id查找对应的员工信息
     * @param employeeId
     * @return
     */
    Employee findEmployeeById(int employeeId);
}

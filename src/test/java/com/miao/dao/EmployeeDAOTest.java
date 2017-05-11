package com.miao.dao;

import com.miao.bean.Employee;
import com.miao.factory.EmployeeDAOFactory;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 10048 on 2017/5/10.
 */
public class EmployeeDAOTest {
    private EmployeeDAO employeeDAO = null;
    @Before
    public void setUp() throws Exception {
        employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
    }

    @Test
    public void addEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeBirth(new Date());
        employee.setEmployeeName("miao");
        employee.setEmployeePhone("17610068133");
        employee.setEmployeePlace("青岛市崂山区松岭路168号");
        employee.setEmployeeSex(true);
        employee.setJoinTime(new Date());
        employee.setPassword("qwert12345");
        employee.setLead(true);

        employeeDAO.addEmployee(employee);
    }

    @Test
    public void updateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birth = "1989-04-05";
        employee.setEmployeeBirth(sdf.parse(birth));
        employee.setEmployeeName("miao");
        employee.setEmployeePhone("17610068133");
        employee.setEmployeePlace("青岛市崂山区松岭路168号 ");
        employee.setEmployeeSex(true);
        employee.setJoinTime(sdf.parse("2017-5-4"));
        employee.setPassword("qwert12345");
        employee.setLead(false);

        employeeDAO.updateEmployee(employee);
    }

    @Test
    public void deleteEmployee() throws Exception {
        employeeDAO.deleteEmployee(2);
    }

    @Test
    public void findAllEmployee() throws Exception {
        List<Employee> employees = employeeDAO.findAllEmployee();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void findEmployeeById() throws Exception {
        Employee employee = employeeDAO.findEmployeeById(3);
        System.out.println(employee);
    }

}
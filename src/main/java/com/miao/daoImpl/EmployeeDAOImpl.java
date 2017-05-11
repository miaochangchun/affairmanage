package com.miao.daoImpl;

import com.miao.bean.Employee;
import com.miao.dao.EmployeeDAO;
import com.miao.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10048 on 2017/5/9.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    public void addEmployee(Employee employee) {
        Connection connection = DBConnection.getConnection();
        String addSQL = "insert into tb_employee(employeeName, employeeSex, employeeBirth, " +
                "employeePhone, employeePlace, joinTime, password, isLead) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(addSQL);
            pstmt.setString(1, employee.getEmployeeName());
            pstmt.setBoolean(2, employee.isEmployeeSex());
            pstmt.setTimestamp(3, new Timestamp(employee.getEmployeeBirth().getTime()));
            pstmt.setString(4, employee.getEmployeePhone());
            pstmt.setString(5, employee.getEmployeePlace());
            pstmt.setTimestamp(6, new Timestamp(employee.getJoinTime().getTime()));
            pstmt.setString(7, employee.getPassword());
            pstmt.setBoolean(8, employee.isLead());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    public void updateEmployee(Employee employee) {
        Connection connection = DBConnection.getConnection();
        String updateSQL = "update tb_employee set employeeName = ?, " +
                "employeeSex = ?, " +
                "employeeBirth = ?, " +
                "employeePhone = ?, " +
                "employeePlace = ?, " +
                "joinTime = ?, " +
                "password = ?, " +
                "isLead = ? " +
                "where employeeId = ?;";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(updateSQL);
            pstmt.setString(1, employee.getEmployeeName());
            pstmt.setBoolean(2, employee.isEmployeeSex());
            pstmt.setTimestamp(3, new Timestamp(employee.getEmployeeBirth().getTime()));
            pstmt.setString(4, employee.getEmployeePhone());
            pstmt.setString(5, employee.getEmployeePlace());
            pstmt.setTimestamp(6, new Timestamp(employee.getJoinTime().getTime()));
            pstmt.setString(7, employee.getPassword());
            pstmt.setBoolean(8, employee.isLead());
            pstmt.setInt(9, employee.getEmployeeId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    public void deleteEmployee(int employeeId) {
        Connection connection = DBConnection.getConnection();
        String deleteSQL = "delete from tb_employee where employeeId = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(deleteSQL);
            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    public List<Employee> findAllEmployee() {
        Connection connection = DBConnection.getConnection();
        String findAllSQL = "select * from tb_employee";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<Employee>();
        Employee employee = null;
        try {
            pstmt = connection.prepareStatement(findAllSQL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setEmployeeBirth(rs.getTimestamp(2));
                employee.setEmployeeName(rs.getString(3));
                employee.setEmployeePhone(rs.getString(4));
                employee.setEmployeePlace(rs.getString(5));
                employee.setEmployeeSex(rs.getBoolean(6));
                employee.setJoinTime(rs.getTimestamp(7));
                employee.setPassword(rs.getString(8));
                employee.setLead(rs.getBoolean(9));
                list.add(employee);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return list;
    }

    public Employee findEmployeeById(int employeeId) {
        Connection conn = DBConnection.getConnection();
        String findByIdSQL = "select * from tb_employee where employeeId = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee employee = null;
        try {
            pstmt = conn.prepareStatement(findByIdSQL);
            pstmt.setInt(1, employeeId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setEmployeeBirth(rs.getTimestamp(2));
                employee.setEmployeeName(rs.getString(3));
                employee.setEmployeePhone(rs.getString(4));
                employee.setEmployeePlace(rs.getString(5));
                employee.setEmployeeSex(rs.getBoolean(6));
                employee.setJoinTime(rs.getTimestamp(7));
                employee.setPassword(rs.getString(8));
                employee.setLead(rs.getBoolean(9));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return employee;
    }
}

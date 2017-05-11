package com.miao.servlet;

import com.miao.bean.Employee;
import com.miao.dao.EmployeeDAO;
import com.miao.factory.EmployeeDAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 10048 on 2017/5/10.
 */
@WebServlet(name = "StatusRecognise", urlPatterns = "/StatusRecognise")
public class StatusRecognise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = null;
        String employyId = request.getParameter("employeeId");
        String password = request.getParameter("password");
        if (employyId == null || "".equals(employyId)) {
            request.setAttribute("error", "请输入员工编号");
            dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
        } else {
            if (password == null || "".equals(password)) {
                request.setAttribute("error", "请输入正确的系统口令");
                dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
            } else {
                EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
                Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employyId));
                if (employee == null) {
                    request.setAttribute("error", "该员工编号不存在");
                    dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
                } else {
                    if (password.equals(employee.getPassword())) {
                        request.getSession().setAttribute("employee", employee);
                        response.sendRedirect("index.jsp");
                        return;
                    } else {
                        request.setAttribute("error", "系统口令不正确");
                        dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
                    }
                }
            }
        }
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

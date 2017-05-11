package com.miao.servlet;

import com.miao.bean.Criticism;
import com.miao.bean.Employee;
import com.miao.dao.CriticismDAO;
import com.miao.factory.CriticismDAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by 10048 on 2017/5/10.
 */
@WebServlet(name = "CommitCriticism", urlPatterns = "/CommitCriticism")
public class CommitCriticism extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String criticismContent = request.getParameter("criticismContent");
        int messageId = Integer.parseInt(request.getParameter("messageId"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = null;

        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if (employee == null) {
            request.setAttribute("error", "要进行批复必须先登录");
        } else {
            if (criticismContent == null || "".equals(criticismContent)) {
                request.setAttribute("error", "必须输入批复内容");
            } else {
                Criticism criticism = new Criticism();
                criticism.setCriticismContent(criticismContent);
                criticism.setEmployeeId(employee.getEmployeeId());
                criticism.setCriticismTime(new Date());
                criticism.setMessageId(messageId);
                CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
                criticismDAO.addCriticism(criticism);
            }
        }
        dispatcher = servletContext.getRequestDispatcher("GetMessage?messageId=" + messageId);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

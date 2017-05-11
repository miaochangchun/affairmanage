package com.miao.servlet;

import com.miao.bean.Employee;
import com.miao.bean.Message;
import com.miao.dao.MessageDAO;
import com.miao.factory.MessageDAOFactory;

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
@WebServlet(name = "MsgPublish", urlPatterns = "/MsgPublish")
public class MsgPublish extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = null;
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if (employee == null) {
            request.setAttribute("error", "要发布消息必须首先进行身份识别");
            dispatcher = servletContext.getRequestDispatcher("/publishNewMsg.jsp");
        } else {
            if (title == null || "".equals(title)) {
                request.setAttribute("error", "必须输入消息标题");
                dispatcher = servletContext.getRequestDispatcher("/publishNewMsg.jsp");
            } else {
                Message message = new Message();
                message.setEmployeeId(employee.getEmployeeId());
                message.setMessageTitle(title);
                message.setMessageContent(content);
                message.setPublishTime(new Date());
                MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
                messageDAO.addMessage(message);
                dispatcher = servletContext.getRequestDispatcher("/GetMessageList");
            }
        }
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

package com.miao.servlet;

import com.miao.bean.Employee;
import com.miao.bean.Reply;
import com.miao.dao.ReplyDAO;
import com.miao.factory.ReplyDAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Date;

/**
 * Created by 10048 on 2017/5/10.
 */
@WebServlet(name = "CommitReply", urlPatterns = "/CommitReply")
public class CommitReply extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String replyContent = request.getParameter("replyContent");
        int messageId = Integer.parseInt(request.getParameter("messageId"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = null;
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if (employee == null) {
            request.setAttribute("error", "要进行回复必须先登录");
        } else {
            if (replyContent == null || "".equals(replyContent)) {
                request.setAttribute("error", "必须输入回复的内容");
            } else {
                Reply reply = new Reply();
                reply.setReplyContent(replyContent);
                reply.setMessageId(messageId);
                reply.setEmployeeId(employee.getEmployeeId());
                reply.setReplyTime(new Date());
                ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
                replyDAO.addReply(reply);
            }
        }
        dispatcher = servletContext.getRequestDispatcher("/GetMessage?messageId=" + messageId);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

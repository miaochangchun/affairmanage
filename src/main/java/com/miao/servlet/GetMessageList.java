package com.miao.servlet;

import com.miao.bean.Message;
import com.miao.dao.MessageDAO;
import com.miao.factory.MessageDAOFactory;
import com.miao.util.Page;
import com.miao.util.PageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

/**
 * Created by 10048 on 2017/5/9.
 */
@WebServlet(name = "GetMessageList", urlPatterns = "/GetMessageList")
public class GetMessageList extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int currentPage = 0;
        String currentPageStr = request.getParameter("currentPage");
        if (currentPageStr == null || "".equals(currentPageStr)) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(currentPageStr);
        }

        MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
        Page page = PageUtil.createPage(5, messageDAO.findAllCount(), currentPage);
        List<Message> messages = messageDAO.findAllMessage(page);
        request.setAttribute("messageList", messages);
        request.setAttribute("page", page);
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/msgList.jsp");
        dispatcher.forward(request, response);
    }
}

package com.miao.servlet;

import com.miao.bean.Criticism;
import com.miao.bean.Message;
import com.miao.bean.Reply;
import com.miao.dao.CriticismDAO;
import com.miao.dao.MessageDAO;
import com.miao.dao.ReplyDAO;
import com.miao.factory.CriticismDAOFactory;
import com.miao.factory.MessageDAOFactory;
import com.miao.factory.ReplyDAOFactory;
import com.miao.util.Page;
import com.miao.util.PageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 10048 on 2017/5/10.
 */
@WebServlet(name = "GetMessage", urlPatterns = "/GetMessage")
public class GetMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int messageId = Integer.parseInt(request.getParameter("messageId"));
        MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
        Message message = messageDAO.findMessageById(messageId);
        request.setAttribute("message", message);

        int currentPage = 0;
        String currentPageStr = request.getParameter("currentPage");
        if (currentPageStr == null || "".equals(currentPageStr)) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(currentPageStr);
        }

        ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
        Page page = PageUtil.createPage(5, replyDAO.findCountByMsgId(messageId), currentPage);
        List<Reply> replies = replyDAO.findReplyByMsgId(messageId, page);
        request.setAttribute("replyList", replies);
        request.setAttribute("page", page);

        CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
        Criticism criticism = criticismDAO.findCriticismByMsgId(messageId);
        request.setAttribute("criticism", criticism);

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/showMsg.jsp");
        dispatcher.forward(request, response);
    }
}

package com.miao.dao;

import com.miao.bean.Message;
import com.miao.factory.MessageDAOFactory;
import com.miao.util.Page;
import com.miao.util.PageUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 10048 on 2017/5/10.
 */
public class MessageDAOTest {
    private MessageDAO messageDAO;
    @Before
    public void setUp() throws Exception {
        messageDAO = MessageDAOFactory.getMessageDAOInstance();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addMessage() throws Exception {
        Message message = new Message();
        message.setEmployeeId(1);
        message.setPublishTime(new Date());
        message.setMessageContent("今天在青岛，天气阴沉");
        message.setMessageTitle("出差");
        System.out.println(message);

        messageDAO.addMessage(message);

    }

    @Test
    public void updateMessage() throws Exception {
        Message message = new Message();
        message.setMessageId(5);
        message.setMessageTitle("出差2");
        message.setMessageContent("广州出差,下了很大的雨");
        message.setPublishTime(new Date());
        message.setEmployeeId(1);

        messageDAO.updateMessage(message);
    }

    @Test
    public void deleteMessage() throws Exception {
        messageDAO.deleteMessage(4);
    }

    @Test
    public void findAllMessage() throws Exception {
        Page page = PageUtil.createPage(5, 4, 1);

        List<Message> messages = messageDAO.findAllMessage(page);
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    @Test
    public void findMessageById() throws Exception {
        Message message = messageDAO.findMessageById(5);
        System.out.println(message);
    }

    @Test
    public void findAllCount() throws Exception {
        int count = messageDAO.findAllCount();
        System.out.println(count);
    }

}
package com.miao.dao;

import com.miao.bean.Reply;
import com.miao.factory.ReplyDAOFactory;
import com.miao.util.Page;
import com.miao.util.PageUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 10048 on 2017/5/10.
 */
public class ReplyDAOTest {
    private ReplyDAO replyDAO = null;
    @Before
    public void setUp() throws Exception {
        replyDAO = ReplyDAOFactory.getReplyDAOInstance();
    }

    @Test
    public void addReply() throws Exception {
        Reply reply = new Reply();
        reply.setReplyContent("呵呵");
        reply.setReplyTime(new Date());
        reply.setEmployeeId(3);
        reply.setMessageId(2);

        replyDAO.addReply(reply);
    }

    @Test
    public void findReplyByMsgId() throws Exception {
        Page page = PageUtil.createPage(4, 2, 1);
        List<Reply> replies = replyDAO.findReplyByMsgId(2, page);
        for (Reply reply : replies) {
            System.out.println(reply);
        }
    }

    @Test
    public void findCountByMsgId() throws Exception {
        int count = replyDAO.findCountByMsgId(2);
        System.out.println(count);
    }

}
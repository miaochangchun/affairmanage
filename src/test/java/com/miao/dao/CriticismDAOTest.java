package com.miao.dao;

import com.miao.bean.Criticism;
import com.miao.factory.CriticismDAOFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by 10048 on 2017/5/10.
 */
public class CriticismDAOTest {
    private CriticismDAO criticismDAO = null;
    @Before
    public void setUp() throws Exception {
        criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
    }

    @Test
    public void addCriticism() throws Exception {
        Criticism criticism = new Criticism();
        criticism.setCriticismContent("同意楼上观点，就这么做吧。");
        criticism.setCriticismTime(new Date());
        criticism.setEmployeeId(3);
        criticism.setMessageId(5);

        criticismDAO.addCriticism(criticism);
    }

    @Test
    public void findCriticismByMsgId() throws Exception {
        Criticism criticism = criticismDAO.findCriticismByMsgId(5);
        System.out.println(criticism);
    }

}
package com.miao.factory;

import com.miao.dao.ReplyDAO;
import com.miao.daoImpl.ReplyDAOImpl;

/**
 * Created by 10048 on 2017/5/9.
 */
public class ReplyDAOFactory {
    /**
     * 工厂方法返回接口的实例对象
     * @return
     */
    public  static ReplyDAO getReplyDAOInstance(){
        return new ReplyDAOImpl();
    }
}

package com.miao.factory;

import com.miao.dao.MessageDAO;
import com.miao.daoImpl.MessageDAOImpl;

/**
 * Created by 10048 on 2017/5/9.
 */
public class MessageDAOFactory {
    /**
     * 工厂方法返回接口的实例对象
     * @return
     */
    public static MessageDAO getMessageDAOInstance(){
        return new MessageDAOImpl();
    }
}

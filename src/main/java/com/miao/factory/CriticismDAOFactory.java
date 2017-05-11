package com.miao.factory;

import com.miao.dao.CriticismDAO;
import com.miao.daoImpl.CriticismDAOImpl;

/**
 * Created by 10048 on 2017/5/9.
 */
public class CriticismDAOFactory {
    /**
     * 工厂方法，返回接口的实例
     * @return
     */
    public static CriticismDAO getCriticismDAOInstance(){
        return new CriticismDAOImpl();
    }
}

package com.miao.factory;

import com.miao.dao.EmployeeDAO;
import com.miao.daoImpl.EmployeeDAOImpl;

/**
 * Created by 10048 on 2017/5/9.
 */
public class EmployeeDAOFactory {
    /**
     * 工厂方法，返回接口的实例对象
     * @return
     */
    public static EmployeeDAO getEmployeeDAOInstance(){
        return new EmployeeDAOImpl();
    }
}

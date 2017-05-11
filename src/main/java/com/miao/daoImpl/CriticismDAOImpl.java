package com.miao.daoImpl;

import com.miao.bean.Criticism;
import com.miao.dao.CriticismDAO;
import com.miao.util.DBConnection;
import com.sun.corba.se.pept.transport.ConnectionCache;

import java.sql.*;

/**
 * Created by 10048 on 2017/5/9.
 */
public class CriticismDAOImpl implements CriticismDAO {
    public void addCriticism(Criticism criticism) {
        Connection connection = DBConnection.getConnection();
        String addSQL = "insert into tb_criticism(criticismContent, employeeId, " +
                "criticismTime, messageId) values (?, ?, ?, ?);";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(addSQL);
            pstmt.setString(1, criticism.getCriticismContent());
            pstmt.setInt(2, criticism.getEmployeeId());
            pstmt.setTimestamp(3, new Timestamp(criticism.getCriticismTime().getTime()));
            pstmt.setInt(4, criticism.getMessageId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }


    }

    public Criticism findCriticismByMsgId(int messageId) {
        Connection connection = DBConnection.getConnection();
        String findSQL = "select * from tb_criticism where messageId = ?";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Criticism criticism = new Criticism();
        try {
            pstmt = connection.prepareStatement(findSQL);
            pstmt.setInt(1, messageId);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                criticism.setCriticismId(resultSet.getInt(1));
                criticism.setCriticismContent(resultSet.getString(2));
                criticism.setEmployeeId(resultSet.getInt(4));
                criticism.setCriticismTime(resultSet.getTimestamp(3));
                criticism.setMessageId(resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close(resultSet);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return criticism;
    }
}

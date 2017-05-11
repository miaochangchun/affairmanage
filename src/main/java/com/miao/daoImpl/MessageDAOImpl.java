package com.miao.daoImpl;

import com.miao.bean.Message;
import com.miao.dao.MessageDAO;
import com.miao.util.DBConnection;
import com.miao.util.Page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10048 on 2017/5/9.
 */
public class MessageDAOImpl implements MessageDAO {
    public void addMessage(Message message) {
        Connection connection = DBConnection.getConnection();
        String addSQL = "insert into tb_message("
                + "messageTitle,"
                + "messageContent,"
                + "employeeId,"
                + "publishTime) values(?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(addSQL);
            pstmt.setString(1, message.getMessageTitle());
            pstmt.setString(2, message.getMessageContent());
            pstmt.setInt(3, message.getEmployeeId());
            pstmt.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    public void updateMessage(Message message) {
        Connection connection = DBConnection.getConnection();
        String updateSQL = "update tb_message set "
                + "messageTitle = ?,"
                + "messageContent = ?,"
                + "employeeId = ?,"
                + "publishTime = ? where messageId = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(updateSQL);
            pstmt.setString(1, message.getMessageTitle());
            pstmt.setString(2, message.getMessageContent());
            pstmt.setInt(3, message.getEmployeeId());
            pstmt.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
            pstmt.setInt(5, message.getMessageId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    public void deleteMessage(int messageId) {
        Connection connection = DBConnection.getConnection();
        String deleteSQL = "delete from tb_message where messageId = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(deleteSQL);
            pstmt.setInt(1, messageId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    public List<Message> findAllMessage(Page page) {
        Connection connection = DBConnection.getConnection();
        String SQL = "select * from tb_message order by publishTime desc limit ?, ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Message> list = new ArrayList<Message>();
        try {
            pstmt = connection.prepareStatement(SQL);
            pstmt.setInt(1, page.getBeginIndex());
            pstmt.setInt(2, page.getEveryPage());
            rs = pstmt.executeQuery();
            while(rs.next()){
                Message message = new Message();
                message.setMessageId(rs.getInt(1));
                message.setMessageTitle(rs.getString(2));
                message.setMessageContent(rs.getString(3));
                message.setEmployeeId(rs.getInt(5));
                message.setPublishTime(rs.getTimestamp(4));
                list.add(message);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return list;
    }

    public Message findMessageById(int messageId) {
        Connection connection = DBConnection.getConnection();
        String SQL = "select * from tb_message where messageId = ?";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Message message = null;
        try {
            pstmt = connection.prepareStatement(SQL);
            pstmt.setInt(1, messageId);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                message = new Message();
                message.setMessageId(resultSet.getInt(1));
                message.setMessageTitle(resultSet.getString(2));
                message.setMessageContent(resultSet.getString(3));
                message.setEmployeeId(resultSet.getInt(5));
                message.setPublishTime(resultSet.getTimestamp(4));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(resultSet);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }

        return message;
    }

    public int findAllCount() {
        Connection connection = DBConnection.getConnection();
        String findSQL = "select count(*) from tb_message";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pstmt = connection.prepareStatement(findSQL);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return count;
    }
}

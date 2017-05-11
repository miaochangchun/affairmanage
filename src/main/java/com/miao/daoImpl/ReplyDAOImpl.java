package com.miao.daoImpl;

import com.miao.bean.Reply;
import com.miao.dao.ReplyDAO;
import com.miao.util.DBConnection;
import com.miao.util.Page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10048 on 2017/5/9.
 */
public class ReplyDAOImpl implements ReplyDAO {
    public void addReply(Reply reply) {
        Connection connection = DBConnection.getConnection();
        String addSQL = "insert into tb_reply(replyContent, employeeId"
                + ", replyTime, messageId) values(?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(addSQL);
            pstmt.setString(1, reply.getReplyContent());
            pstmt.setInt(2, reply.getEmployeeId());
            pstmt.setTimestamp(3, new Timestamp(reply.getReplyTime().getTime()));
            pstmt.setInt(4, reply.getMessageId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    public List<Reply> findReplyByMsgId(int messageId, Page page) {
        Connection connection = DBConnection.getConnection();
        String findSQL = "SELECT * FROM tb_reply WHERE messageId = ? LIMIT ?, ?";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<Reply> list = new ArrayList<Reply>();
        try {
            pstmt = connection.prepareStatement(findSQL);
            pstmt.setInt(1, messageId);
            pstmt.setInt(2, page.getBeginIndex());
            pstmt.setInt(3, page.getEveryPage());
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Reply reply = new Reply();
                reply.setReplyId(resultSet.getInt(1));
                reply.setReplyContent(resultSet.getString(2));
                reply.setEmployeeId(resultSet.getInt(4));
                reply.setReplyTime(resultSet.getTimestamp(3));
                reply.setMessageId(resultSet.getInt(5));
                list.add(reply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close(resultSet);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return list;
    }

    public int findCountByMsgId(int messageId) {
        Connection connection = DBConnection.getConnection();
        String countSQL = "select count(*) from tb_reply where messageId = ?";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            pstmt = connection.prepareStatement(countSQL);
            pstmt.setInt(1, messageId);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close(resultSet);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return count;
    }
}

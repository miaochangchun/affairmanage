package com.miao.dao;

import com.miao.bean.Message;
import com.miao.util.Page;

import java.util.List;

/**
 * Created by 10048 on 2017/5/9.
 */
public interface MessageDAO {
    /**
     * 添加文章
     * @param message
     */
    void addMessage(Message message);

    /**
     * 更新文章
     * @param message
     */
    void updateMessage(Message message);

    /**
     * 删除文章
     * @param messageId
     */
    void deleteMessage(int messageId);

    /**
     * 分页查找所有的文章信息
     * @param page  分页类
     * @return
     */
    List<Message> findAllMessage(Page page);

    /**
     * 按照文章Id查找文章信息
     * @param messageId 文章id
     * @return
     */
    Message findMessageById(int messageId);

    /**
     * 查询文章的所有条目数
     * @return
     */
    int findAllCount();
}

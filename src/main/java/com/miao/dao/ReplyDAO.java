package com.miao.dao;

import com.miao.bean.Reply;
import com.miao.util.Page;

import java.util.List;

/**
 * Created by 10048 on 2017/5/9.
 */
public interface ReplyDAO {
    /**
     * 添加文章回复
     * @param reply
     */
    void addReply(Reply reply);

    /**
     * 按照文章的Id查找所有的回复并分页显示
     * @param messageId 文章id
     * @param page  分页信息
     * @return
     */
    List<Reply> findReplyByMsgId(int messageId, Page page);

    /**
     * 根据文章的id信息，统计回复的条目数
     * @param messageId
     * @return
     */
    int findCountByMsgId(int messageId);
}

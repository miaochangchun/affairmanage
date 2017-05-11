package com.miao.dao;

import com.miao.bean.Criticism;

/**
 * Created by 10048 on 2017/5/9.
 */
public interface CriticismDAO {
    /**
     * 添加批复
     * @param criticism 批复内容
     */
    public void addCriticism(Criticism criticism);

    /**
     * 按照文章Id查找批复
     * @param messageId 文章Id
     * @return  批复内容
     */
    public Criticism findCriticismByMsgId(int messageId);
}

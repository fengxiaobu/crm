package com.crm.dao;

import com.crm.entity.Linkman;

import java.util.List;

/**
 * luopa 在 2017/3/3 创建.
 */
public interface LinkManDao {
    void addLinkman(Linkman linkman);

    List<Linkman> findLinkmanAll();

    void delLnkman(Linkman linkman);

    Linkman findById(Integer lkmid);
}

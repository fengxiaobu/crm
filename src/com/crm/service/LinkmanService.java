package com.crm.service;

import com.crm.entity.Linkman;

import java.util.List;

/**
 * luopa 在 2017/3/3 创建.
 */
public interface LinkmanService {

    void addLinkman(Linkman linkman);

    List<Linkman> findLinkmanAll();

    Linkman findById(Integer lkmid);

    void delLnkman(Linkman linkman);
}

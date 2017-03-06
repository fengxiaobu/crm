package com.crm.service.serviceimpl;

import com.crm.dao.LinkManDao;
import com.crm.entity.Linkman;
import com.crm.service.LinkmanService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * luopa 在 2017/3/3 创建.
 */
@Transactional
public class LinkmanServiceImpl implements LinkmanService {
private LinkManDao linkManDao;

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    @Override
    public void addLinkman(Linkman linkman) {
        linkManDao.addLinkman(linkman);
    }

    @Override
    public List<Linkman> findLinkmanAll() {
        return linkManDao.findLinkmanAll();
    }

    @Override
    public Linkman findById(Integer lkmid) {

        return linkManDao.findById(lkmid);
    }

    @Override
    public void delLnkman(Linkman linkman) {

        linkManDao.delLnkman(linkman);
    }
}

package com.crm.dao.daoimpl;

import com.crm.dao.LinkManDao;
import com.crm.entity.Linkman;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/**
 * luopa 在 2017/3/3 创建.
 */
public class LinkManDaoImpl implements LinkManDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void addLinkman(Linkman linkman) {
        hibernateTemplate.saveOrUpdate(linkman);
    }

    @Override
    public List<Linkman> findLinkmanAll() {
        return (List<Linkman>) hibernateTemplate.find("from Linkman");
    }

    @Override
    public void delLnkman(Linkman linkman) {
        hibernateTemplate.delete(linkman);
    }

    @Override
    public Linkman findById(Integer lkmid) {
        List<Linkman> list = (List<Linkman>) hibernateTemplate.find("from Linkman where  lkmid=?", lkmid);

        return list.get(0);
    }
}

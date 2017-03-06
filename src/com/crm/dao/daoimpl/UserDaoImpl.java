package com.crm.dao.daoimpl;

import com.crm.dao.UserDao;
import com.crm.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/**
 * luopa 在 2017/2/28 创建.
 */
public class UserDaoImpl implements UserDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public User login(User user) {
        List<User> list = (List<User>) hibernateTemplate.find("from User where username=? and  password=?", user.getUsername(), user.getPassword());
        if (list != null && list.size() != 0) {
            User exitUser = new User();
            exitUser = list.get(0);
            return exitUser;
        }
        return null;
    }
}

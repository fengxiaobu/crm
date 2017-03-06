package com.crm.service.serviceimpl;

import com.crm.dao.UserDao;
import com.crm.entity.User;
import com.crm.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * luopa 在 2017/2/28 创建.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}

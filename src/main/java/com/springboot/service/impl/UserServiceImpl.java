package com.springboot.service.impl;

import com.springboot.dao.UserDao;
import com.springboot.obj.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangbenben on 2018/5/12 0012
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User selectByPrimaryKey(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int deleteByList(List<Integer> idList) {
        return userDao.deleteByList(idList);
    }


}

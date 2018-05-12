package com.springboot.service;

import com.springboot.obj.User;

/**
 * @author zhangbenben on 2018/5/11 0011
 */
public interface UserService  {
    /**
     * @param: id 主键
     * @return: User
     * @date: 2018/5/11 0011 2018-05-11
     * @description: 通过主键查找实体
     */
    User selectByPrimaryKey(Integer id);

}

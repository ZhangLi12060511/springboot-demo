package com.springboot.dao;

import com.springboot.obj.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangbenben on 2018/5/11 0011
 */

public interface UserDao  {
    /**
     * @param: id 主键
     * @return: User
     * @date: 2018/5/11 0011 2018-05-11
     * @description: 通过主键查找实体
     */
    User selectByPrimaryKey(@Param("id") Integer id);

}

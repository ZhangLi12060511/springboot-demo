package com.springboot.service;

import com.springboot.obj.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    /**
     * @param: name
     * @return: User
     * @date: 2018/5/13 0013 2018-05-13
     * @description:
     */
    User selectByName(@Param("name") String name);
    /**
     * @param: user
     * @return: int
     * @date: 2018/5/12 0012 2018-05-12
     * @description:
     */
    int insert(User user);

    /**
     * @param: user
     * @return: int
     * @date: 2018/5/12 0012 2018-05-12
     * @description:
     */
    int update(User user);
    /**
     * @param: id
     * @return: void
     * @date: 2018/5/12 0012 2018-05-12
     * @description:
     */
    int  deleteById(@Param("id") Integer id);

    /**
     * @param: list
     * @return: int
     * @date: 2018/5/13 0013 2018-05-13
     * @description:
     */
    int  deleteByList(List<Integer> idList);

}

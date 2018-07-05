package com.springboot.dao;

import com.springboot.obj.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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
     * @param:
     * @return:
     * @date: 2018/5/13 0013 2018-05-13
     * @description:
     */
    int  deleteByList(@Param("idList") List<Integer> idList);
<<<<<<< HEAD


=======
>>>>>>> 107fb41... 增删改查初步已经完成，增加了相关的工具类

}

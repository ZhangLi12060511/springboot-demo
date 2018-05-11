package com.springboot.dao;

/**
 * @author zhangbenben on 2018/5/11 0011
 */
public interface Dao<T> {

    /**
     * @param: id 主键
     * @return: User
     * @date: 2018/5/11 0011 2018-05-11
     * @description: 通过主键查找实体
     */
    T selectByPrimaryKey(Integer id);
    /**
     * @param: t 实体类
     * @return: int
     * @date: 2018/5/11 0011 2018-05-11
     * @description:插入实体类
     */
    int insert(T t);
    /**
     * @param: t
     * @return: T
     * @date: 2018/5/11 0011 2018-05-11
     * @description:更新实体类
     */
    int update(T t);
    /**
     * @param: t
     * @return: T
     * @date: 2018/5/11 0011 2018-05-11
     * @description:
     */
    int delete(T t);

}

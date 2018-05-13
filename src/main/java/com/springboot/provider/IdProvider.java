package com.springboot.provider;

import java.util.UUID;

/**
 * @author zhangbenben on 2018/5/13 0013
 */
public class IdProvider {
    /**
     * Description:通过uuid生成唯一的记录id
     * @Version 1.0 2016-8-24下午8:40:48
     * @return 生成的id
     */
    public static String createUUIDId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}

package com.springboot.obj;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangbenben on 2018/5/11 0011
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
}

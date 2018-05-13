package com.springboot.exception;

import com.springboot.util.Constants;

import java.io.Serializable;

/**
 * @author zhangbenben on 2018/5/13 0013
 */
public class ServiceExcetion extends RuntimeException implements Serializable {

    public   static final String MESSAGE = "逻辑异常";

    public static  final int CODE = Constants.ERROR_CODE;

    public ServiceExcetion(){
        super(MESSAGE);
    }

    public ServiceExcetion(String message){
        super(message);
    }

}

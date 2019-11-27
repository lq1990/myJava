package com.mycp.springboot.exception;

/**
 * @author lq
 * create 2019-11-23 11:26
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }


}

package com.mycp.springboot.controller;

import com.mycp.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * diy异常处理机制
 *
 * @author lq
 * create 2019-11-23 11:42
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 自定义1. 浏览器 客户端返回的都是json
     * @param e
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//
//        return map;

//    }


    //自定义2. 浏览器 客户端返回的都是json
//    @ExceptionHandler(UserNotExistException.class)
//    public String handleException(Exception e, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<>();
//
//        // 传入status
//        request.setAttribute("javax.servlet.error.status_code", 400);
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//
//
//        return "forward:/error"; // 交给BasicErrorController进行自适应处理
//    }

    // 自定义3：将我们的自定义数据携带
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        // 传入status
        request.setAttribute("javax.servlet.error.status_code", 400);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());

        // +++++++
        request.setAttribute("ext", map); // 将map放到req作用域

        return "forward:/error"; // 交给BasicErrorController进行自适应处理
    }


}

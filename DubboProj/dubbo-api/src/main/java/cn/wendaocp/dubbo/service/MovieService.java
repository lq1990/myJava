package cn.wendaocp.dubbo.service;

import cn.wendaocp.dubbo.bean.Movie;

/**
 * @author lq
 * create 2020-02-16 12:33
 */
public interface MovieService {

    // 获取最新电影
    public Movie getNewMovie();

}

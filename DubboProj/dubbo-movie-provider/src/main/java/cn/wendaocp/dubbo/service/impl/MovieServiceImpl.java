package cn.wendaocp.dubbo.service.impl;

import cn.wendaocp.dubbo.bean.Movie;
import cn.wendaocp.dubbo.service.MovieService;

/**
 *
 * @author lq
 * create 2020-02-16 12:34
 */
public class MovieServiceImpl implements MovieService {

    @Override
    public Movie getNewMovie() {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setMovieName("复联4");
        movie.setPrice(96.99);
        System.out.println("电影服务查询到最新的电影: "+movie.getMovieName());

        return movie;
    }


}

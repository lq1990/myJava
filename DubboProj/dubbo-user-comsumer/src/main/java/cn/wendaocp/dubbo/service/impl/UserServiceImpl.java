package cn.wendaocp.dubbo.service.impl;

import cn.wendaocp.dubbo.bean.Movie;
import cn.wendaocp.dubbo.bean.Order;
import cn.wendaocp.dubbo.bean.User;
import cn.wendaocp.dubbo.service.MovieService;
import cn.wendaocp.dubbo.service.UserService;

 /**
 * @author lq
 * create 2020-02-16 12:07
 */
public class UserServiceImpl implements UserService {

    // 只需声明
    MovieService movieService;

     public MovieService getMovieService() {
         return movieService;
     }

     public void setMovieService(MovieService movieService) {
         this.movieService = movieService;
     }

     @Override
    public Order buyNewMovie(User user) {
        // 1. 远程查询最新电影并返回
        Movie newMovie = movieService.getNewMovie();
        System.out.println("远程调用movie服务获取到结果: "+newMovie);

        // 2. 封装order对象返回
        Order order = new Order();
        order.setUserName(user.getUserName());
        order.setMovieId(newMovie.getId());
        order.setMovieName(newMovie.getMovieName());
        return order;
    }


}

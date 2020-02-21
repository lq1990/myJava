package cn.wendaocp.dubbo.service.impl;

import cn.wendaocp.dubbo.bean.Movie;
import cn.wendaocp.dubbo.service.MovieService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 *
 * @author lq
 * create 2020-02-16 12:34
 */
@Component // 本工程内Spring组件可以Autowired
@Service(version = "2.0") // 使用dubbo的，将此服务暴露，为了别的工程能远程调
public class MovieServiceImpl implements MovieService {

    @Override
    public Movie getNewMovie() {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setMovieName("复联4");
        movie.setPrice(96.99);
        System.out.println("20881--v2.0, 电影服务查询到最新的电影: "+movie.getMovieName());

        return movie;
    }
}

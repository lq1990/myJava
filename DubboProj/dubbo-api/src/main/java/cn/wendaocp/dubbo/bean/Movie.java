package cn.wendaocp.dubbo.bean;

import java.io.Serializable;

/**
 * @author lq
 * create 2020-02-16 12:32
 */
public class Movie implements Serializable {

    private Integer id;
    private String movieName;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", price=" + price +
                '}';
    }
}

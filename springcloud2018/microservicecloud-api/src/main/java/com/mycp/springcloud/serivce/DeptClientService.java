package com.mycp.springcloud.serivce;

import com.mycp.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 注解使得： 针对某个微服务进行 面向接口编程。
 *   注解中定义了value，这样其它服务可以根据接口 访问到这个微服务
 *
 *
 *    在接口上写 熔断处理。
 *    可以和主程序解耦。
 *
 * @author lq
 * create 2020-01-08 14:10
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    public List<Dept> list();

    @PostMapping("/dept/add")
    public boolean add(Dept dept);

}

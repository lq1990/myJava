package cn.wendaocp.gmall.oms.service.impl;

import cn.wendaocp.gmall.oms.entity.Order;
import cn.wendaocp.gmall.oms.mapper.OrderMapper;
import cn.wendaocp.gmall.oms.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-02-24
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}

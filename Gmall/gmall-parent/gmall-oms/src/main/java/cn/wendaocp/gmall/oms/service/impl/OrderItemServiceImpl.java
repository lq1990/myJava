package cn.wendaocp.gmall.oms.service.impl;

import cn.wendaocp.gmall.oms.entity.OrderItem;
import cn.wendaocp.gmall.oms.mapper.OrderItemMapper;
import cn.wendaocp.gmall.oms.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-02-24
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}

package cn.wendaocp.gmall.oms.service.impl;

import cn.wendaocp.gmall.oms.entity.CartItem;
import cn.wendaocp.gmall.oms.mapper.CartItemMapper;
import cn.wendaocp.gmall.oms.service.CartItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-02-24
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {

}

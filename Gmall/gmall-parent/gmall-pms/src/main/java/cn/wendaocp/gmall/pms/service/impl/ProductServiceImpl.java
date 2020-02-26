package cn.wendaocp.gmall.pms.service.impl;

import cn.wendaocp.gmall.pms.entity.Product;
import cn.wendaocp.gmall.pms.mapper.ProductMapper;
import cn.wendaocp.gmall.pms.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-02-24
 */
@Service
public class ProductServiceImpl
        extends ServiceImpl<ProductMapper, Product> implements ProductService {

}

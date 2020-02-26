package cn.wendaocp.gmall.pms.service.impl;

import cn.wendaocp.gmall.pms.entity.Brand;
import cn.wendaocp.gmall.pms.mapper.BrandMapper;
import cn.wendaocp.gmall.pms.service.BrandService;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-02-24
 */
@Service
@Component
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

}

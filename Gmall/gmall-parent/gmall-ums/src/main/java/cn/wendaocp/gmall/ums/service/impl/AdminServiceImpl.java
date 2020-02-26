package cn.wendaocp.gmall.ums.service.impl;

import cn.wendaocp.gmall.ums.entity.Admin;
import cn.wendaocp.gmall.ums.mapper.AdminMapper;
import cn.wendaocp.gmall.ums.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-02-24
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}

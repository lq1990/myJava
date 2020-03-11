package cn.wendaocp.gmall.ums.service;

import cn.wendaocp.gmall.ums.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author lq
 * @since 2020-02-24
 */
public interface AdminService extends IService<Admin> {

    Admin login(String username, String password);

}

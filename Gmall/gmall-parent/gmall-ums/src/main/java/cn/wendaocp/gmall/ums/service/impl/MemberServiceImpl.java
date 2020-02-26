package cn.wendaocp.gmall.ums.service.impl;

import cn.wendaocp.gmall.ums.entity.Member;
import cn.wendaocp.gmall.ums.mapper.MemberMapper;
import cn.wendaocp.gmall.ums.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-02-24
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}

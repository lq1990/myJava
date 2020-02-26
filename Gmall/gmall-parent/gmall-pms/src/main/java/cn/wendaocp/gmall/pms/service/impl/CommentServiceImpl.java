package cn.wendaocp.gmall.pms.service.impl;

import cn.wendaocp.gmall.pms.entity.Comment;
import cn.wendaocp.gmall.pms.mapper.CommentMapper;
import cn.wendaocp.gmall.pms.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-02-24
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}

package com.xgit.boot.service.impl;

import com.xgit.boot.entity.MBlog;
import com.xgit.boot.mapper.MBlogMapper;
import com.xgit.boot.service.MBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tianxuanxuan
 * @since 2020-09-12
 */

@Service("mBlogService")
public class MBlogServiceImpl extends ServiceImpl<MBlogMapper, MBlog> implements MBlogService {

}

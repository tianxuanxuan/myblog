package com.xgit.boot.service.impl;

import com.xgit.boot.entity.MUser;
import com.xgit.boot.mapper.MUserMapper;
import com.xgit.boot.service.MUserService;
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

@Service
public class MUserServiceImpl extends ServiceImpl<MUserMapper, MUser> implements MUserService {

}

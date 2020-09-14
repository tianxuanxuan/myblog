package com.xgit.boot.shiro.shiro_service;

import cn.hutool.core.bean.BeanUtil;
import com.xgit.boot.entity.MUser;
import com.xgit.boot.service.MUserService;
import com.xgit.boot.shiro.handler.AccountProfile;
import com.xgit.boot.shiro.handler.AccountRealm;
import com.xgit.boot.shiro.handler.JwtToken;
import com.xgit.boot.shiro.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tianxuanxuan
 * On 2020-09-14 10:46
 */
@Slf4j
@Component
public class ServiceAccountRealm extends AccountRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    MUserService mUserService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwt = (JwtToken) token;
        log.info("jwt----------------->{}", jwt);
        String userId = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();
        MUser mUser = mUserService.getById(Long.parseLong(userId));
        if(mUser == null) {
            throw new UnknownAccountException("账户不存在！");
        }
        if(mUser.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定！");
        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(mUser, profile);
        log.info("profile----------------->{}", profile.toString());
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());
    }
}

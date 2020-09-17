package com.xgit.boot.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xgit.boot.common_utils.CommonResult;
import com.xgit.boot.entity.MUser;
import com.xgit.boot.entity.md.LoginMD;
import com.xgit.boot.entity.md.SignInMD;
import com.xgit.boot.service.MUserService;
import com.xgit.boot.service_base.handler.CustomExceptionHandler;
import com.xgit.boot.shiro.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by tianxuanxuan
 * On 2020-09-14 11:49
 */

@Slf4j
@RestController
@RequestMapping("/service-blog/account")
public class AccountLoginController {
    @Autowired
    private MUserService mUserService;

    @Autowired
    private JwtUtils jwtUtils;

    @CrossOrigin
    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody LoginMD loginMD, HttpServletResponse response){
        MUser user = mUserService.getOne(new QueryWrapper<MUser>().eq("username", loginMD.getUsername()));
        Assert.notNull(user, "用户不存在");
        if(!user.getPassword().equals(SecureUtil.md5(loginMD.getPassword()))){
            return CommonResult.error().message("密码错误");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        return CommonResult.ok().data("loginMD", MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );
    }

    @GetMapping("/logout")
    public CommonResult logOut(){
        SecurityUtils.getSubject().logout();
        return CommonResult.ok();
    }

    @PostMapping("sign")
    public CommonResult sign(@Validated @RequestBody SignInMD signInMD){
        /*
         * 判断用户
         */
        MUser user = mUserService.getOne(new QueryWrapper<MUser>( ).eq("username", signInMD.getUsername()));
        if (!StringUtils.isEmpty(user)){
            throw  new CustomExceptionHandler(20001, "用户名已被注册");
        }else {
            user = mUserService.getOne(new QueryWrapper<MUser>().eq("email", signInMD.getEmail()));
            if (!StringUtils.isEmpty(user)){
                throw new CustomExceptionHandler(20001, "邮箱已被注册");
            }
        }

        //注册新用户
        MUser mUser = new MUser();
        BeanUtils.copyProperties(signInMD, mUser);
        mUser.setPassword(SecureUtil.md5(signInMD.getPassword())); //加密密码
        mUser.setStatus(1); //初始状态1，表示正常
        mUser.setIsDelete(false); //初始状态0，表示未删除
        mUser.setAvatar("https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg"); //头像先给个默认值
        boolean saveResult = mUserService.save(mUser);
        if (saveResult) {
            return CommonResult.ok();
        }
        throw new CustomExceptionHandler(20001, "注册失败");
    }
}

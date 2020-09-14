package com.xgit.boot.controller;


import com.xgit.boot.common_utils.CommonResult;
import com.xgit.boot.entity.MUser;
import com.xgit.boot.service.MUserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tianxuanxuan
 * @since 2020-09-12
 */
@RestController
@RequestMapping("/service-blog/m-user")
public class MUserController {
    @Autowired
    private MUserService mUserService;

    @RequiresAuthentication
    @GetMapping("selectAll")
    public CommonResult getAll(){
        List<MUser> result = mUserService.list();
        return CommonResult.ok().data("all", result);
    }

    @PostMapping("login")
    public CommonResult login(@Validated @RequestBody MUser mUser){
        return CommonResult.ok().data("user", mUser);
    }
}


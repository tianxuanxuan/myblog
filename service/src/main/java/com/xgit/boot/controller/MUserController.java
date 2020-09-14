package com.xgit.boot.controller;


import com.xgit.boot.common_utils.CommonResult;
import com.xgit.boot.entity.MUser;
import com.xgit.boot.service.impl.MUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    private MUserServiceImpl mUserService;

    @GetMapping("selectAll")
    public CommonResult getAll(){
        List<MUser> result = mUserService.list();
        return CommonResult.ok().data("all", result);
    }
}


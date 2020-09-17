package com.xgit.boot.controller;


import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xgit.boot.common_utils.CommonResult;
import com.xgit.boot.entity.MBlog;
import com.xgit.boot.entity.md.InsertBlogMD;
import com.xgit.boot.service.MBlogService;
import com.xgit.boot.service_base.handler.CustomExceptionHandler;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tianxuanxuan
 * @since 2020-09-12
 */
@RestController
@RequestMapping("/service-blog/m-blog")
public class MBlogController {
    @Autowired
    private MBlogService mBlogService;

    @ApiOperation("添加博客")
    @PostMapping("insertBlog")
    public CommonResult insertBlog(@ApiParam(name = "blog", value = "博客信息")
                                   @Validated @RequestBody InsertBlogMD blog) {
        MBlog mBlog = new MBlog();
        BeanUtils.copyProperties(blog, mBlog);
        mBlog.setStatus(0); //0表示未发布状态
        mBlog.setIsDelete(false); //false表示未删除
        boolean saveResult = mBlogService.save(mBlog);
        if (saveResult) {
            return CommonResult.ok().message("保存成功");
        }
        throw new CustomExceptionHandler(20001, "保存失败");
    }

    @ApiOperation("根据id删除博客")
    @DeleteMapping("/deleteBlogById/{id}")
    public CommonResult deleteById(@ApiParam(name = "id", value = "博客id")
                                   @PathVariable String id) {
        boolean result = mBlogService.removeById(id);
        if (result) {
            return CommonResult.ok().message("删除成功");
        }
        throw new CustomExceptionHandler(20001, "删除失败");
    }

    @ApiOperation("根据id查询博客")
    @GetMapping("/selectBlogById/{id}")
    public CommonResult selectById(@ApiParam(name = "id", value = "博客id")
                                   @PathVariable(name = "id") Long id) {
        MBlog mBlog = mBlogService.getById(id);
        Assert.notNull(mBlog, "" + "该博客已删除");
        return CommonResult.ok().data("blog", mBlog);
    }

    @ApiOperation("根据id更新博客")
    @PutMapping("updateBlogById")
    public CommonResult updateById(@ApiParam(name = "blog", value = "博客信息")
                                   @Validated @RequestBody InsertBlogMD blog) {
        MBlog mBlog = mBlogService.getById(blog.getId());
        Assert.notNull(mBlog, "" + "该博客已删除");
        mBlog.setContent(blog.getContent());
        mBlog.setTitle(blog.getTitle());
        mBlog.setDescription(blog.getDescription());
        mBlog.setStatus(blog.getStatus());
        boolean updateResult = mBlogService.updateById(mBlog);
        if (updateResult){
            return CommonResult.ok().message("更新成功");
        }
        throw new CustomExceptionHandler(20001, "更新失败");
    }

    @ApiOperation("分页查询博客")
    @GetMapping("limitSelect/{current}/{size}")
    public CommonResult limitSelect(@ApiParam(name = "current", value = "当前页", required = true)
                                    @PathVariable("current") Long current,
                                    @ApiParam(name = "size", value = "每页记录数")
                                    @PathVariable("size") Long size) {
        QueryWrapper<MBlog> queryWrapper = new QueryWrapper<MBlog>();
        queryWrapper.orderByDesc("gmt_modified");
        Page<MBlog> page = new Page<>(current, size);
        return CommonResult.ok().data("limitBlog", mBlogService.page(page,queryWrapper));
    }
}


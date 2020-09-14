package com.xgit.boot.shiro.handler;

import com.xgit.boot.common_utils.CommonResult;
import com.xgit.boot.service_base.handler.MyExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by tianxuanxuan
 * On 2020-09-14 11:05
 */
@Slf4j
@Component
public class ShiroExceptionHandler extends MyExceptionHandler {
    // 捕捉shiro的异常
    @ResponseBody
    @ExceptionHandler(ShiroException.class)
    public CommonResult handle401(org.apache.shiro.ShiroException e) {
        return CommonResult.error().code(401).message("你好"+e.getMessage());
    }
    /**
     * 处理Assert的异常
     */
    @ResponseBody
    @ExceptionHandler(value = IllegalArgumentException.class)
    public CommonResult handler(IllegalArgumentException e) throws IOException {
        return CommonResult.error().message(e.getMessage());
    }
    /**
     * @Validated 校验错误异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult handler(MethodArgumentNotValidException e) throws IOException {
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        return CommonResult.error().message(objectError.getDefaultMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public CommonResult handler(RuntimeException e) throws IOException {
        return CommonResult.error().message(e.getMessage());
    }
}

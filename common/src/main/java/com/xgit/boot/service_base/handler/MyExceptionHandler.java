package com.xgit.boot.service_base.handler;

import com.xgit.boot.common_utils.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tianxuanxuan
 * On 2020-09-14 09:37
 */
@ControllerAdvice//全局异常处理、全局数据绑定、全局数据预处理
public class MyExceptionHandler {
    @ExceptionHandler(CustomExceptionHandler.class)
    @ResponseBody
    public CommonResult customError(CustomExceptionHandler e){
        return CommonResult.error().code(e.getCode()).message(e.getMessage());
    }
}

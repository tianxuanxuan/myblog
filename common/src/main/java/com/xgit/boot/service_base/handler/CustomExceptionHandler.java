package com.xgit.boot.service_base.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by tianxuanxuan
 * On 2020-09-14 09:34
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor //自动生成有参构造方法，参数是所有参数
@NoArgsConstructor  //自动生成无参构造
public class CustomExceptionHandler extends RuntimeException{
    private Integer code;
    private String message;
}

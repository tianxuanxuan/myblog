package com.xgit.boot.shiro.handler;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by tianxuanxuan
 * On 2020-09-14 10:23
 */
@Data
public class AccountProfile implements Serializable {
    /**
     * 这是为了登录成功之后返回的一个用户信息的载体，
     */
    private Long id;
    private String username;
    private String avatar;
}

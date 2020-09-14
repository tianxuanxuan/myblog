package com.xgit.boot.shiro.handler;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by tianxuanxuan
 * On 2020-09-14 10:24
 */
public class JwtToken implements AuthenticationToken {

    /**
     * shiro默认supports的是UsernamePasswordToken，而我们现在采用了jwt的方式，
     * 所以这里我们自定义一个JwtToken，来完成shiro的supports方法
     */
    private final String token;
    public JwtToken(String token){
        this.token = token;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

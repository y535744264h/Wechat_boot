package com.cctv.project.wechat.base.config;

import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

/**
 * @program: Wechat->WxToken
 * @description:
 * @author: yanhao
 * @create: 2019-11-28 13:59
 **/
public class WxToken implements HostAuthenticationToken, RememberMeAuthenticationToken {

    private String openId;
    private boolean rememberMe;
    private String host;

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public boolean isRememberMe() {
        return this.rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }


    @Override
    public Object getPrincipal() {
        return this.openId;
    }

    @Override
    public Object getCredentials() {
        return this.openId;
    }


    public WxToken(String openId) {
        this(openId,true,(String)null);
    }

    public WxToken(String openId, boolean rememberMe, String host) {
        this.openId = openId;
        this.rememberMe = rememberMe;
        this.host = host;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "WxToken{" +
                "openId='" + openId + '\'' +
                ", rememberMe=" + rememberMe +
                ", host='" + host + '\'' +
                '}';
    }
}

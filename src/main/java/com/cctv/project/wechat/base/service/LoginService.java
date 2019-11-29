package com.cctv.project.wechat.base.service;

import com.cctv.project.wechat.base.entity.WxUser;

/**
 * @program: Wechat->LoginService
 * @description:
 * @author: yanhao
 * @create: 2019-11-28 14:13
 **/
public interface LoginService {
    WxUser login(String openId);
}

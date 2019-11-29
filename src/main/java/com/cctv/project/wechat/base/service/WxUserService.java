package com.cctv.project.wechat.base.service;

import com.cctv.project.wechat.base.entity.WxUser;

/**
 * @program: Wechat->WxUser
 * @description: 微信用户相关
 * @author: yanhao
 * @create: 2019-11-28 11:18
 **/
public interface WxUserService {
    WxUser selectWxUserByOpenId(String openId);

    void updateUserInfo(WxUser user);

    int insertSelective(WxUser record);
}

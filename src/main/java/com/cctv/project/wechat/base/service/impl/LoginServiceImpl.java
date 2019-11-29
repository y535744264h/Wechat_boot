package com.cctv.project.wechat.base.service.impl;

import com.cctv.project.wechat.base.entity.WxUser;
import com.cctv.project.wechat.base.service.LoginService;
import com.cctv.project.wechat.base.service.WxUserService;
import com.cctv.project.wechat.base.util.WeChatUtil;
import com.cctv.project.wechat.system.exception.user.*;
import com.cctv.project.wechat.system.util.DateUtils;
import com.cctv.project.wechat.system.util.StringUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: Wechat->LoginServiceImpl
 * @description:
 * @author: yanhao
 * @create: 2019-11-28 14:15
 **/

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    WxUserService wxUserService;

    @Autowired
    WxMpService wxMpService;

    @Autowired
    WeChatUtil weChatUtil;


    @Override
    public WxUser login(String openId) {

        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(openId) || StringUtils.isEmpty(openId)) {
            throw new UserNotExistsException();
        }

        // 查询微信用户信息
        WxUser wxUser=wxUserService.selectWxUserByOpenId(openId);

        if (wxUser == null) {
            String accessCode=weChatUtil.getAccessToken();
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken=new WxMpOAuth2AccessToken();
            wxMpOAuth2AccessToken.setAccessToken(accessCode);
            wxMpOAuth2AccessToken.setOpenId(openId);
            try {
                WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
                wxUser= new WxUser(wxMpUser);
                if(wxUser==null||StringUtils.isEmpty(wxUser.getOpenid())){
                    throw new UserNotExistsException();
                }
            } catch (WxErrorException e) {
                e.printStackTrace();
                throw new UserNotExistsException();
            }

        }
        recordLoginInfo(wxUser);
        return wxUser;
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(WxUser user) {
        user.setLoginDate(DateUtils.getNowDate());
        wxUserService.updateUserInfo(user);
    }

}

package com.cctv.project.wechat.base.util;

import com.cctv.project.wechat.base.constant.WeChatConstants;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: Wechat->WeChatUtil
 * @description: 微信工具类
 * @author: yanhao
 * @create: 2019-11-28 14:27
 **/
@Component
public class WeChatUtil {

    @Autowired
    WxMpService wxMpService;


    @Autowired
    RedisUtil redisUtil;

    /**
     * access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。
     * @return
     */
    public String getAccessToken(){
        String accessToken= (String) redisUtil.get(WeChatConstants.REDIS_ACCESSTOKEN);
        if(accessToken==null){
            try {
                accessToken=wxMpService.getAccessToken();
                redisUtil.set(WeChatConstants.REDIS_ACCESSTOKEN,accessToken,7000);
            } catch (WxErrorException e) {
                e.printStackTrace();
            }

        }
        return accessToken;
    }

}

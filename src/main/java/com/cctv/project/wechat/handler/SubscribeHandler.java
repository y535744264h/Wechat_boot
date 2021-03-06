package com.cctv.project.wechat.handler;

import com.cctv.project.wechat.base.entity.WxUser;
import com.cctv.project.wechat.base.service.WxUserService;
import com.cctv.project.wechat.system.service.ConfigService;
import com.cctv.project.wechat.system.util.StringUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.builder.kefu.TextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class SubscribeHandler extends AbstractHandler {

    @Autowired
    WxUserService wxUserService;

    @Autowired
    ConfigService configService;

    @Value("wechat.userName")
    String userName;



    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

        // 获取微信用户基本信息
        try {
            WxMpUser userWxInfo = weixinService.getUserService()
                .userInfo(wxMessage.getFromUser(), null);
            if (userWxInfo != null) {
                WxUser wxUser=new WxUser(userWxInfo);
                wxUserService.saveWxUser(wxUser);
            }
        } catch (WxErrorException e) {
            if (e.getError().getErrorCode() == 48001) {
                this.logger.info("该公众号没有获取用户信息权限！");
            }
        }


        WxMpXmlOutMessage responseResult = null;
        try {
            responseResult = this.handleSpecial(wxMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        if (responseResult != null) {
            return responseResult;
        }

        try {

            String msg=configService.selectConfigByKey("welcome_msg");
            if(StringUtils.isNotEmpty(msg)){
                WxMpXmlOutMessage wxMpXmlOutMessage= WxMpXmlOutMessage.TEXT()
                        .content(msg)
                        .fromUser(userName)
                        .toUser(wxMessage.getFromUser())
                        .build();
                System.out.println(wxMpXmlOutMessage.toXml());
                return wxMpXmlOutMessage;
            }
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
        throws Exception {
        //TODO
        return null;
    }

}

package com.cctv.project.wechat.base.ccontroller;

import com.cctv.project.wechat.base.config.WxToken;
import com.cctv.project.wechat.system.util.StringUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: Wechat->LoginController
 * @description:
 * @author: yanhao
 * @create: 2019-11-29 09:22
 **/
@Controller
public class LoginController {

    @Autowired
    WxMpService wxMpService;

    @GetMapping("wxLogin")
    public String login(HttpServletRequest request,String openId,String redirectUrl){
        System.out.println("------------------");
        WxToken wxToken=new WxToken(openId);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(wxToken);
            return "redirect:"+redirectUrl;
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return "";
        }
    }
}

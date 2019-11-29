package com.cctv.project.wechat.base.shiro;

import com.cctv.project.wechat.base.entity.WxUser;
import com.cctv.project.wechat.base.service.WxUserService;
import com.cctv.project.wechat.system.util.StringUtils;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author by yanhao
 * @Classname TokenFilter
 * @Description TODO
 * @Date 2019/11/18 5:25 下午
 */
public class TokenFilter implements Filter {


    WxMpService wxMpService;

    WxUserService wxUserService;

    public TokenFilter(WxMpService wxMpService, WxUserService wxUserService) {
        this.wxMpService = wxMpService;
        this.wxUserService = wxUserService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        String openid = (String) session.getAttribute("OPENID");

        if (StringUtils.isEmpty(openid) && StringUtils.isNotEmpty(code)) {
            String url = request.getScheme() + "://"
                    + request.getServerName()
                    + request.getRequestURI()
                    + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
            try {
                WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
                WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);

                //判断用户是否在数据库中 如果没有 则入库
                WxUser wxUser = new WxUser(wxMpUser);
                wxUserService.saveWxUser(wxUser);
                session.setAttribute("OPENID", wxMpUser.getOpenId());
                String baseUrl = request.getScheme() + "://"
                        + request.getServerName();
                String redirect = baseUrl + "/wxLogin?openId=" + wxMpUser.getOpenId() + "&redirectUrl=" + URLEncoder.encode(url) + "&code" + code;
                ((HttpServletResponse) servletResponse).sendRedirect(redirect);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

package com.cctv.project.wechat.base.shiro;

import com.cctv.project.wechat.system.config.Global;
import com.cctv.project.wechat.system.util.StringUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author by yanhao
 * @Classname AuthorizationFilter
 * @Description 判断用户Session中是否有OpenID （可以理解为 是否进行OAuth验证过）
 * @Date 2019/11/18 3:36 下午
 */
public class AuthorizationFilter implements Filter {



    WxMpService wxMpService;

    public AuthorizationFilter(WxMpService wxMpService) {
        this.wxMpService=wxMpService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpSession session=request.getSession();
        String code=request.getParameter("code");
        String openid= (String) session.getAttribute("OPENID");

        if(StringUtils.isEmpty(code)&&StringUtils.isEmpty(openid)){

            String url = request.getScheme() + "://"
                    + request.getServerName()
                    + request.getRequestURI()
                    + (request.getQueryString() != null ? "?" + request.getQueryString() : "");

            String redirEctUrl=wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
            ((HttpServletResponse)servletResponse).sendRedirect(redirEctUrl);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
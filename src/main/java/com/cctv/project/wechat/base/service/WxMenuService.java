package com.cctv.project.wechat.base.service;

import java.util.Set;

/**
 * @program: Wechat->MenuService
 * @description: 微信菜单相关
 * @author: yanhao
 * @create: 2019-11-28 11:16
 **/
public interface WxMenuService {
    Set<String> selectPermsByOpenId(String openid);
}

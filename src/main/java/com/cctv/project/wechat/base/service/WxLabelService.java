package com.cctv.project.wechat.base.service;

import java.util.Set;

/**
 * @program: Wechat->WxLabelService
 * @description: 微信标签相关
 * @author: yanhao
 * @create: 2019-11-28 11:18
 **/
public interface WxLabelService {
    Set<String> selectLabelNameByOpenId(String openid);
}

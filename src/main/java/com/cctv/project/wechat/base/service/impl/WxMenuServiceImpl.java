package com.cctv.project.wechat.base.service.impl;

import com.cctv.project.wechat.base.mapper.WxMenuMapper;
import com.cctv.project.wechat.base.service.WxMenuService;
import com.cctv.project.wechat.system.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: Wechat->WxMenuServiceImpl
 * @description:
 * @author: yanhao
 * @create: 2019-11-28 15:48
 **/
@Service
public class WxMenuServiceImpl implements WxMenuService {

    @Autowired
    WxMenuMapper wxMenuMapper;

    @Override
    public Set<String> selectPermsByOpenId(String openid) {
        List<String> menuList=wxMenuMapper.selectByOpenId(openid);
        Set<String> permsSet = new HashSet<>();
        for (String perm : menuList) {
            if (StringUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}

package com.cctv.project.wechat.base.service.impl;

import com.cctv.project.wechat.base.entity.WxLabel;
import com.cctv.project.wechat.base.mapper.WxLabelMapper;
import com.cctv.project.wechat.base.service.WxLabelService;
import com.cctv.project.wechat.system.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: Wechat->WxLabelServiceImpl
 * @description:
 * @author: yanhao
 * @create: 2019-11-28 15:04
 **/
@Service
public class WxLabelServiceImpl implements WxLabelService {

    @Autowired
    WxLabelMapper wxLabelMapper;

    @Override
    public Set<String> selectLabelNameByOpenId(String openid) {
        List<WxLabel> list=wxLabelMapper.selectLabelByOpenId(openid);
        Set<String> permsSet = new HashSet<>();
        for (WxLabel perm : list) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getLabelName().trim().split(",")));
            }
        }
        return permsSet;
    }
}

package com.cctv.project.wechat.base.service.impl;

import com.cctv.project.wechat.base.entity.WxUser;
import com.cctv.project.wechat.base.mapper.WxUserMapper;
import com.cctv.project.wechat.base.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Wechat->WxUserServiceImpl
 * @description:
 * @author: yanhao
 * @create: 2019-11-28 17:35
 **/
@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    WxUserMapper wxUserMapper;

    @Override
    public WxUser selectWxUserByOpenId(String openId) {
        return wxUserMapper.selectWxUserByOpenId(openId);
    }

    @Override
    public void updateUserInfo(WxUser user) {
        wxUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int insertSelective(WxUser record) {
        return wxUserMapper.insertSelective(record);
    }
}

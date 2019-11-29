package com.cctv.project.wechat.base.mapper;

import com.cctv.project.wechat.base.entity.WxUser;
import com.cctv.project.wechat.base.entity.WxUserKey;

public interface WxUserMapper {
    int deleteByPrimaryKey(WxUserKey key);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(WxUserKey key);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);

    WxUser selectWxUserByOpenId(String openId);
}
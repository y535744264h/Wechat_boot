package com.cctv.project.wechat.base.mapper;

import com.cctv.project.wechat.base.entity.WxLabelUser;

public interface WxLabelUserMapper {
    int deleteByPrimaryKey(Long labelId);

    int insert(WxLabelUser record);

    int insertSelective(WxLabelUser record);

    WxLabelUser selectByPrimaryKey(Long labelId);

    int updateByPrimaryKeySelective(WxLabelUser record);

    int updateByPrimaryKey(WxLabelUser record);
}
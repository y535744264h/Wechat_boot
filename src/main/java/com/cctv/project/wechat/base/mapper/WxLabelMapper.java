package com.cctv.project.wechat.base.mapper;

import com.cctv.project.wechat.base.entity.WxLabel;

import java.util.List;

public interface WxLabelMapper {
    int deleteByPrimaryKey(Long labelId);

    int insert(WxLabel record);

    int insertSelective(WxLabel record);

    WxLabel selectByPrimaryKey(Long labelId);

    int updateByPrimaryKeySelective(WxLabel record);

    int updateByPrimaryKey(WxLabel record);

    List<WxLabel> selectLabelByOpenId(String openid);
}
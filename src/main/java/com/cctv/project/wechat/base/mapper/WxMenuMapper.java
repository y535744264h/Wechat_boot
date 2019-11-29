package com.cctv.project.wechat.base.mapper;

import com.cctv.project.wechat.base.entity.WxMenu;
import com.cctv.project.wechat.base.entity.WxMenuKey;

import java.util.List;

public interface WxMenuMapper {
    int deleteByPrimaryKey(WxMenuKey key);

    int insert(WxMenu record);

    int insertSelective(WxMenu record);

    WxMenu selectByPrimaryKey(WxMenuKey key);

    int updateByPrimaryKeySelective(WxMenu record);

    int updateByPrimaryKey(WxMenu record);

    List<String> selectByOpenId(String openId);
}
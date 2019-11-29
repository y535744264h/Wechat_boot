package com.cctv.project.wechat.system.service;

import com.cctv.project.wechat.system.entity.SysConfig;

import java.util.List;

/**
 * @author by yanhao
 * @Classname ConfigService
 * @Description TODO
 * @Date 2019/10/11 10:20 上午
 */
public interface ConfigService {
    String selectConfigByKey(String s);

    List<SysConfig> selectConfigList(SysConfig config);

    String checkConfigKeyUnique(SysConfig config);

    int insertConfig(SysConfig config);

    SysConfig selectConfigById(Long configId);

    int updateConfig(SysConfig config);

    int deleteConfigByIds(String ids);

    int updateConfig(String key, String value);
}

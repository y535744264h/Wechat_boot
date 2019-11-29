package com.cctv.project.wechat.system.mapper;

import com.cctv.project.wechat.system.entity.SysConfig;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Integer configId);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(Integer configId);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

    SysConfig selectConfig(SysConfig config);

    int updateConfig(SysConfig config);

    @Update("update sys_config set config_value = #{configValue} where config_key= #{configKey}")
    int updateConfigKV(@Param("configKey") String configKey, @Param("configValue") String configValue);

    int deleteConfigByIds(String[] toStrArray);

    int insertConfig(SysConfig config);

    SysConfig checkConfigKeyUnique(String configKey);

    List<SysConfig> selectConfigList(SysConfig config);
}
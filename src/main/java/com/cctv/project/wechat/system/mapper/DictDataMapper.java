package com.cctv.project.wechat.system.mapper;

import com.cctv.project.wechat.system.entity.DictData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictDataMapper {
    int deleteByPrimaryKey(Long dictCode);

    int insert(DictData record);

    int insertSelective(DictData record);

    DictData selectByPrimaryKey(Long dictCode);

    int updateByPrimaryKeySelective(DictData record);

    int updateByPrimaryKey(DictData record);


    List<DictData> selectDictDataByType(String dictType);

    String selectDictLabel(String dictType, String dictValue);

    /**
     * 查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据
     */
    public int countDictDataByType(String dictType);

    /**
     * 同步修改字典类型
     *
     * @param oldDictType 旧字典类型
     * @param newDictType 新旧字典类型
     * @return 结果
     */
    int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);

    List<DictData> selectDictDataList(DictData dictData);

    int insertDictData(DictData dict);

    DictData selectDictDataById(Long dictCode);

    int updateDictData(DictData dict);

    int deleteDictDataByIds(String[] toStrArray);

    int saveOrUpdateVdnErrorCount(DictData dictData);

    DictData selectDictDataByKeyType(@Param("dictLabel") String dictLabel, @Param("dictType") String dictType);
}
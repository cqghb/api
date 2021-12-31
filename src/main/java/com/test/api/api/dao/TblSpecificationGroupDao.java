package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSpecificationGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品规格组持久层接口
 */
@Repository
public interface TblSpecificationGroupDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblSpecificationGroup record);

    int insertSelective(TblSpecificationGroup record);

    TblSpecificationGroup selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblSpecificationGroup record);

    int updateByPrimaryKey(TblSpecificationGroup record);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<TblSpecificationGroup> queryList(JSONObject record);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSpecificationGroup record);

    /**
     * 通过分组名称查询
     * @param name 分组名称
     * @param delTag 删除标记
     * @return
     */
    List<TblSpecificationGroup> queryByName(@Param("name") String name, @Param("delTag") String delTag);
}
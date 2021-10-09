package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblDataOperate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblDataOperateDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblDataOperate record);

    int insertSelective(TblDataOperate record);

    TblDataOperate selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblDataOperate record);

    int updateByPrimaryKey(TblDataOperate record);

    /**
     * 列表查询
     * @param record 查询条件
     * @return
     */
    List<TblDataOperate> queryList(JSONObject record);

    /**
     * 修改角色删除标志
     * @param record 角色对象
     * @return
     */
    int updateDelTag(TblDataOperate record);
}
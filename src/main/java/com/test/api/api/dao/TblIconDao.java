package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblIcon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图标持久层接口
 */
@Repository
public interface TblIconDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblIcon record);

    int insertSelective(TblIcon record);

    TblIcon selectByPKDelTag(@Param("id") String id, @Param("delTag") String delTag);

    TblIcon selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblIcon record);

    int updateByPrimaryKey(TblIcon record);

    /**
     * 列表查询
     * @param params 查询条件
     * @return
     */
    List<TblIcon> queryList(JSONObject params);

    /**
     * 修改图报表删除标志
     * @param record 图标对象
     * @return
     */
    int updateDelTag(TblIcon record);
}
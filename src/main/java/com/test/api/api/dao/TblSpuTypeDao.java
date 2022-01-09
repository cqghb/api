package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSpuType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 货品类型持久层接口
 */
@Repository
public interface TblSpuTypeDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblSpuType record);

    int insertSelective(TblSpuType record);

    TblSpuType selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblSpuType record);

    int updateByPrimaryKey(TblSpuType record);

    /**
     * 分页查询
     *
     * @param record 查询条件
     * @return
     */
    List<TblSpuType> queryList(JSONObject record);

    /**
     * 修改删除标志
     *
     * @param record 更新数据
     * @return
     */
    int updateDelTag(TblSpuType record);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<TblSpuType> query(TblSpuType record);
}
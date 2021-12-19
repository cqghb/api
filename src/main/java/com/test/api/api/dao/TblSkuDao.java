package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSku;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品持久层接口
 */
@Repository
public interface TblSkuDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblSku record);

    int insertSelective(TblSku record);

    TblSku selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblSku record);

    int updateByPrimaryKey(TblSku record);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<TblSku> queryList(JSONObject record);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSku record);
}
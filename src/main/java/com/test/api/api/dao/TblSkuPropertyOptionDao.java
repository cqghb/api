package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSkuPropertyOption;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 属性选项关联表持久化接口
 */
@Repository
public interface TblSkuPropertyOptionDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblSkuPropertyOption record);

    int insertSelective(TblSkuPropertyOption record);

    TblSkuPropertyOption selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblSkuPropertyOption record);

    int updateByPrimaryKey(TblSkuPropertyOption record);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<TblSkuPropertyOption> queryList(JSONObject record);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSkuPropertyOption record);
}
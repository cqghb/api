package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblProperty;
import com.test.api.api.vo.commodity.property.PropertyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品属性持久层接口
 */
@Repository
public interface TblPropertyDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblProperty record);

    int insertSelective(TblProperty record);

    TblProperty selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblProperty record);

    int updateByPrimaryKey(TblProperty record);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<TblProperty> queryList(JSONObject record);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblProperty record);

    /**
     * 通过产品属性ID查询属性详细信息
     * @param id 产品属性ID
     * @return
     */
    PropertyVo queryDetail(@Param("id") String id);
}
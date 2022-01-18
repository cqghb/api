package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblPropertyOptions;
import com.test.api.api.vo.commodity.property_option.PropertyOptionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品属性选项持久层接口
 */
@Repository
public interface TblPropertyOptionsDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblPropertyOptions record);

    int insertSelective(TblPropertyOptions record);

    TblPropertyOptions selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblPropertyOptions record);

    int updateByPrimaryKey(TblPropertyOptions record);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<TblPropertyOptions> queryList(JSONObject record);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblPropertyOptions record);

    /**
     * 查询产品属性值详情
     * @param id 产品属性值ID
     * @return
     */
    PropertyOptionVo queryDetail(String id);
}
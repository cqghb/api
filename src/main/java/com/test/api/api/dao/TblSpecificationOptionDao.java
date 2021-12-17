package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSpecificationOption;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品规格选项持久层接口
 */
@Repository
public interface TblSpecificationOptionDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblSpecificationOption record);

    int insertSelective(TblSpecificationOption record);

    TblSpecificationOption selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblSpecificationOption record);

    int updateByPrimaryKey(TblSpecificationOption record);

    /**
     * 列表查询
     * @param record 查询条件
     * @return
     */
    List<TblSpecificationOption> queryList(JSONObject record);

    /**
     * 修改删除标志
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSpecificationOption record);
}
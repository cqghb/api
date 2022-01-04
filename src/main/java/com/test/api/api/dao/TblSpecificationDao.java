package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSpecification;
import com.test.api.api.vo.commodity.specification.SpecificationVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品规格持久层接口
 */
@Repository
public interface TblSpecificationDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblSpecification record);

    int insertSelective(TblSpecification record);

    TblSpecification selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblSpecification record);

    int updateByPrimaryKey(TblSpecification record);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<TblSpecification> queryList(JSONObject record);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSpecification record);

    /**
     * 查询产品规格详情
     * @param id 产品规格主键
     * @return
     */
    SpecificationVO queryDetail(@Param("id") String id);
}
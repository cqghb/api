package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSkuSpecificationOption;
import com.test.api.api.vo.commodity.skuspecificationoption.SkuSpecificationOptionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 规格选项关联持久化接口
 */
@Repository
public interface TblSkuSpecificationOptionDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblSkuSpecificationOption record);

    int insertSelective(TblSkuSpecificationOption record);

    TblSkuSpecificationOption selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblSkuSpecificationOption record);

    int updateByPrimaryKey(TblSkuSpecificationOption record);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<SkuSpecificationOptionVO> queryList(JSONObject record);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSkuSpecificationOption record);
}
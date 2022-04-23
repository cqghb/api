package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSpuBrand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品品牌持久层接口
 */
@Repository
public interface TblSpuBrandDao {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblSpuBrand record);

    int insertSelective(TblSpuBrand record);

    TblSpuBrand selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(TblSpuBrand record);

    int updateByPrimaryKey(TblSpuBrand record);

    /**
     * 列表查询
     * @param record 查询条件
     * @return
     */
    List<TblSpuBrand> queryList(JSONObject record);

    /**
     * 修改角色删除标志
     * @param record 角色对象
     * @return
     */
    int updateDelTag(TblSpuBrand record);

    /**
     * 查询一条[主键ID、品牌名称、品牌编码均只能查出一条数据]
     * @param record
     * @return
     */
    TblSpuBrand queryOne(TblSpuBrand record);
}
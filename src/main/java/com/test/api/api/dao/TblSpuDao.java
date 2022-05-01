package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSpu;
import com.test.api.api.vo.commodity.spu.ListSpuVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 货品持久层接口
 */
@Repository
public interface TblSpuDao {

    int deleteByPrimaryKey(@Param("id") String id);

    int insert(TblSpu record);

    int insertSelective(TblSpu record);

    TblSpu selectByPrimaryKey(@Param("id") String id);

    /**
     * 根据货品编码查询货品信息
     * @param code 货品编码
     * @return
     */
    TblSpu queryByCode(@Param("code") String code);

    int updateByPrimaryKeySelective(TblSpu record);

    int updateByPrimaryKey(TblSpu record);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<ListSpuVO> queryList(JSONObject record);

    /**
     * 修改删除标志
     *
     * @param record 更新数据
     * @return
     */
    int updateDelTag(TblSpu record);

    /**
     * 查询货品详细信息
     *
     * @param id 货品主键
     * @return
     */
    ListSpuVO selectDetail(@Param("id") String id);

    /**
     * 货品列表查询
     * @param record 查询条件
     * @return
     */
    List<TblSpu> searchList(TblSpu record);
}
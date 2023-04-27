package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.api.api.bean.TblSpu;
import com.test.api.api.vo.commodity.spu.ListSpuVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.dao
 * @className TblSpuExtendsDao
 * @description TODO
 * @auther wangsheng
 * @creatTime 2023/4/24 上午1:25
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Repository
public interface TblSpuExtendsDao extends TblSpuDao, BaseMapper<TblSpu> {

    /**
     * 查询SPU的ID和名称
     * @param no 货品编号
     * @return
     */
    List<Map<String, String>> searchSpuNoName(@Param("no") String no);

    /**
     * 根据货品编码查询货品信息
     * @param no 货品编号
     * @return
     */
    TblSpu queryByNo(@Param("no") String no);

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

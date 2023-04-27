package com.test.api.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.api.api.bean.TblSpu;
import com.test.api.api.config.AppException;
import com.test.api.api.vo.commodity.spu.ListSpuVO;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSpuService
 * @description 货品服务接口
 * @auther wangsheng
 * @creatTime 2021/12/15 下午11:29
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSpuService extends IService<TblSpu> {

    int deleteByPrimaryKey(String id);

    int insert(TblSpu record);
    /**
     * 添加货品信息
     * @param record 货品信息
     * @return
     */
    int insertSelective(TblSpu record);

    TblSpu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpu record);

    int updateByPrimaryKey(TblSpu record);

    /**
     * 分页查询
     * @param pageRequest 分页参数
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

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
    ListSpuVO selectDetail(String id);

    /**
     * 货品编码不能重复
     * @param code 货品编码
     * @throws AppException
     */
    void spuCodeRepeat(String code) throws AppException;

    /**
     * 根据货品编码查询货品信息
     *
     * @param code 货品编码
     * @return
     */
    TblSpu queryByCode(String code);

    /**
     * 查询SPU的ID和名称
     * @param code spu 代码
     * @return
     */
    List<Map<String, String>> searchSpuCodeName(String code);

}

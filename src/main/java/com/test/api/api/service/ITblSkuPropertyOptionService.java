package com.test.api.api.service;

import com.test.api.api.bean.TblSkuPropertyOption;
import com.test.api.api.vo.commodity.skupropertyoption.SkuPropertyOptionVO;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSkuPropertyOptionService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/12/19 下午5:48
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSkuPropertyOptionService {

    int deleteByPrimaryKey(String id);

    int insert(TblSkuPropertyOption record);

    int insertSelective(TblSkuPropertyOption record);

    TblSkuPropertyOption selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSkuPropertyOption record);

    int updateByPrimaryKey(TblSkuPropertyOption record);

    /**
     * 分页查询
     * @param pageRequest 分页参数
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSkuPropertyOption record);

    /**
     * 通过主键查询产品属性信息
     * @param id 产品属性值关系主键
     * @return
     */
    SkuPropertyOptionVO queryDetail(String id);
}

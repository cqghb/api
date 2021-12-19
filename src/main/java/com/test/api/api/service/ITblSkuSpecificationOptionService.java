package com.test.api.api.service;

import com.test.api.api.bean.TblSkuSpecificationOption;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSkuSpecificationOptionService
 * @description 产品规格选项关联服务接口
 * @auther wangsheng
 * @creatTime 2021/12/19 下午5:57
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSkuSpecificationOptionService {

    int deleteByPrimaryKey(String id);

    int insert(TblSkuSpecificationOption record);

    int insertSelective(TblSkuSpecificationOption record);

    TblSkuSpecificationOption selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSkuSpecificationOption record);

    int updateByPrimaryKey(TblSkuSpecificationOption record);

    /**
     * 列表查询
     *
     * @param pageRequest 查询条件
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSkuSpecificationOption record);
}

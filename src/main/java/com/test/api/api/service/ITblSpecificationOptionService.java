package com.test.api.api.service;

import com.test.api.api.bean.TblSpecificationOption;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSpecificationOptionService
 * @description 产品规格选项服务接口
 * @auther wangsheng
 * @creatTime 2021/12/16 下午11:42
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSpecificationOptionService {

    int deleteByPrimaryKey(String id);

    int insert(TblSpecificationOption record);

    int insertSelective(TblSpecificationOption record);

    TblSpecificationOption selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpecificationOption record);

    int updateByPrimaryKey(TblSpecificationOption record);

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 修改删除标志
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSpecificationOption record);
}

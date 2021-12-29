package com.test.api.api.service;

import com.test.api.api.bean.TblSpecificationGroup;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSpecificationGroupService
 * @description 产品规格分组服务接口
 * @auther wangsheng
 * @creatTime 2021/12/30 上午12:38
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSpecificationGroupService {

    int deleteByPrimaryKey(String id);

    int insert(TblSpecificationGroup record);

    int insertSelective(TblSpecificationGroup record);

    TblSpecificationGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpecificationGroup record);

    int updateByPrimaryKey(TblSpecificationGroup record);

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 修改删除标志
     *
     * @param record 对象
     * @return
     */
    int updateDelTag(TblSpecificationGroup record);
}

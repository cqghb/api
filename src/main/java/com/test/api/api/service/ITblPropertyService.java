package com.test.api.api.service;

import com.test.api.api.bean.TblProperty;
import com.test.api.api.vo.commodity.property.PropertyVo;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblPropertyService
 * @description 产品属性服务接口
 * @auther wangsheng
 * @creatTime 2021/12/20 上午12:48
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblPropertyService {

    int deleteByPrimaryKey(String id);

    int insert(TblProperty record);

    int insertSelective(TblProperty record);

    TblProperty selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblProperty record);

    int updateByPrimaryKey(TblProperty record);

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
    int updateDelTag(TblProperty record);

    /**
     * 通过产品属性ID查询属性详细信息
     * @param id 产品属性ID
     * @return
     */
    PropertyVo queryDetail(String id);
}

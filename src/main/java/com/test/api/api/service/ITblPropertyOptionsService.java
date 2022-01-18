package com.test.api.api.service;

import com.test.api.api.bean.TblPropertyOptions;
import com.test.api.api.vo.commodity.property_option.PropertyOptionVo;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblPropertyOptionsService
 * @description 产品属性选项服务接口
 * @auther wangsheng
 * @creatTime 2021/12/20 上午12:48
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblPropertyOptionsService {

    int deleteByPrimaryKey(String id);

    int insert(TblPropertyOptions record);

    int insertSelective(TblPropertyOptions record);

    TblPropertyOptions selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblPropertyOptions record);

    int updateByPrimaryKey(TblPropertyOptions record);

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
    int updateDelTag(TblPropertyOptions record);

    /**
     * 查询产品属性值详情
     * @param id 产品属性值ID
     * @return
     */
    PropertyOptionVo queryDetail(String id);
    /**
     * 检查产品属性值是否存在
     * @param id 产品属性值ID
     * @return
     */
    TblPropertyOptions checkPropertyOption(String id);
    /**
     * 检查产品属性值是否已经失效
     * @param id 产品属性值ID
     */
    void checkDelTag(String id);
}

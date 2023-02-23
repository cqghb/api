package com.test.api.api.service;

import com.test.api.api.bean.TblSku;
import com.test.api.api.dto.commodity.sku.AddSkuDto;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSkuService
 * @description 产品服务接口
 * @auther wangsheng
 * @creatTime 2021/12/19 下午5:39
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSkuService {

    int deleteByPrimaryKey(String id);

    int insert(TblSku record);

    int insertSelective(AddSkuDto addSkuDto);

    TblSku selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSku record);

    int updateByPrimaryKey(TblSku record);

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
    int updateDelTag(TblSku record);
}

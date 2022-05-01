package com.test.api.api.service;

import com.test.api.api.bean.TblSpuBrand;
import com.test.api.api.config.AppException;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSpuBrandService
 * @description 商品品牌服务层接口
 * @auther wangsheng
 * @creatTime 2021/12/14 上午12:35
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSpuBrandService {

    int deleteByPrimaryKey(String id);

    int insert(TblSpuBrand record);

    int insertSelective(TblSpuBrand record) throws AppException;

    TblSpuBrand selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpuBrand record);

    int updateByPrimaryKey(TblSpuBrand record);

    /**
     * 分页查询
     * @param pageRequest 分页参数
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 修改角色删除标志
     * @param record 角色对象
     * @return
     */
    int updateDelTag(TblSpuBrand record) throws AppException;

    /**
     * 检查货品品牌是否存在，如不存在则抛出异常
     *
     * @param id 货品品牌主键
     */
    TblSpuBrand checkSpuBrand(String id);

    /**
     * 检查货品品牌是否已经失效，如已经失效则抛出异常
     *
     * @param id 货品品牌主键
     */
    void checkSpuBrandDelTag(String id);

}

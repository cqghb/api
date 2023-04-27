package com.test.api.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.api.api.bean.TblSpecification;
import com.test.api.api.vo.commodity.specification.SpecificationVO;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.apache.ibatis.annotations.Param;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSpecificationService
 * @description 产品规格服务接口
 * @auther wangsheng
 * @creatTime 2021/12/16 上午12:28
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSpecificationService extends IService<TblSpecification> {

    int deleteByPrimaryKey(String id);

    int insert(TblSpecification record);

    int insertSelective(TblSpecification record);

    TblSpecification selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpecification record);

    int updateByPrimaryKey(TblSpecification record);

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
    int updateDelTag(TblSpecification record);

    /**
     * 查询产品规格详情
     * @param id 产品规格主键
     * @return
     */
    SpecificationVO queryDetail(@Param("id") String id);
}

package com.test.api.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.api.api.bean.TblSkuAfterSales;
import org.springframework.stereotype.Repository;

/**
 * @projectName api
 * @package com.test.api.api.dao
 * @className TblSkuAfterSalesExtendsDao
 * @description TODO
 * @auther wangsheng
 * @creatTime 2023/4/21 下午5:48
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Repository
public interface TblSkuAfterSalesExtendsDao extends TblSkuAfterSalesDao, BaseMapper<TblSkuAfterSales> {
}

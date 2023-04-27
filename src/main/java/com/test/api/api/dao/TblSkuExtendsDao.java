package com.test.api.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.api.api.bean.TblSku;
import org.springframework.stereotype.Repository;

/**
 * @projectName api
 * @package com.test.api.api.dao
 * @className TblSkuExtendsDao
 * @description 商品持久层自定义方法
 * @auther wangsheng
 * @creatTime 2023/4/19 上午7:54
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Repository
public interface TblSkuExtendsDao extends TblSkuDao, BaseMapper<TblSku> {

}

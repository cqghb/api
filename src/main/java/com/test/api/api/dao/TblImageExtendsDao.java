package com.test.api.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.api.api.bean.TblImage;
import org.springframework.stereotype.Repository;

/**
 * @projectName api
 * @package com.test.api.api.dao
 * @className TblImageExtendsDao
 * @description TODO
 * @auther wangsheng
 * @creatTime 2023/4/21 下午6:11
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Repository
public interface TblImageExtendsDao extends TblImageDao, BaseMapper<TblImage> {
}

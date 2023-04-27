package com.test.api.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.api.api.bean.TblSkuAfterSales;
import com.test.api.api.dao.TblSkuAfterSalesExtendsDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblSkuAfterSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblSkuAfterSalesService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2023/4/21 下午6:01
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSkuAfterSalesService extends ServiceImpl<TblSkuAfterSalesExtendsDao, TblSkuAfterSales> implements ITblSkuAfterSalesService {

    @Autowired
    private TblSkuAfterSalesExtendsDao tblSkuAfterSalesExtendsDao;
    @Autowired
    private ICommonService iCommonService;

}

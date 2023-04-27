package com.test.api.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.api.api.bean.TblImage;
import com.test.api.api.dao.TblImageExtendsDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className TblImageService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2023/4/21 下午6:14
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblImageService extends ServiceImpl<TblImageExtendsDao, TblImage> implements ITblImageService {

    @Autowired
    private TblImageExtendsDao tblImageExtendsDao;

    @Autowired
    private ICommonService iCommonService;

}

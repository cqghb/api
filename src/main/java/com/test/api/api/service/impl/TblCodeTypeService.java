package com.test.api.api.service.impl;

import com.test.api.api.dao.TblCodeTypeDao;
import com.test.api.api.service.ITblCodeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblCodeTypeService
 * @description 码值类型服务实现类
 * @auther wangsheng
 * @creatTime 2021/5/10 12:29 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblCodeTypeService implements ITblCodeTypeService {

    @Autowired
    private TblCodeTypeDao tblCodeTypeDao;
}

package com.test.api.api.service.impl;

import com.test.api.api.dao.TblRoleUserRelationDao;
import com.test.api.api.service.ITblRoleUserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblRoleUserRelationService
 * @description 用户角色关系服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/29 2:10 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblRoleUserRelationService implements ITblRoleUserRelationService {

    @Autowired
    private TblRoleUserRelationDao roleUserRelationDao;
}

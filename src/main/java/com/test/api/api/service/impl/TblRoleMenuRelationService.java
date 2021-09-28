package com.test.api.api.service.impl;

import com.test.api.api.dao.TblRoleMenuRelationDao;
import com.test.api.api.service.ITblRoleMenuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblRoleMenuRelationService
 * @description 角色菜单关系服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/29 2:08 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblRoleMenuRelationService implements ITblRoleMenuRelationService {

    @Autowired
    private TblRoleMenuRelationDao roleMenuRelationDao;
}

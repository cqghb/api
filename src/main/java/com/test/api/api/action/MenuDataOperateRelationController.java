package com.test.api.api.action;

import com.test.api.api.service.ITblMenuDataOperateRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className MenuDataOperateRelationController
 * @description 菜单数据操作权限关系控制器
 * @auther wangsheng
 * @creatTime 2021/9/29 2:12 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@Api(value = "菜单数据操作权限关系控制器")
@RequestMapping("/menuDataOperateRelation")
public class MenuDataOperateRelationController {

    @Autowired
    private ITblMenuDataOperateRelationService menuDataOperateRelationService;
}

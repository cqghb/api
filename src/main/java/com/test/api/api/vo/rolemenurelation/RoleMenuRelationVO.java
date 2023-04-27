package com.test.api.api.vo.rolemenurelation;

import com.test.api.api.bean.TblRoleMenuRelation;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo.rolemenurelation
 * @className RoleMenuRelationVO
 * @description 角色菜单视图对象
 * @auther wangsheng
 * @creatTime 2021/11/5 1:58 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class RoleMenuRelationVO extends TblRoleMenuRelation implements Serializable {
    private static final long serialVersionUID = 2277122435066595162L;

    private List childrenList;
}

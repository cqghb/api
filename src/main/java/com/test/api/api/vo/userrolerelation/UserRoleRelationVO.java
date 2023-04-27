package com.test.api.api.vo.userrolerelation;

import com.test.api.api.bean.TblRoleUserRelation;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo.rolemenurelation
 * @className RoleMenuRelationVO
 * @description 用户角色视图对象
 * @auther wangsheng
 * @creatTime 2021/11/5 1:58 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class UserRoleRelationVO extends TblRoleUserRelation implements Serializable {

    private static final long serialVersionUID = 523734233729739297L;
    private List childrenList;
}

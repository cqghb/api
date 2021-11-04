package com.test.api.api.vo.rolemenurelation;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblRoleMenuRelation;

import java.io.Serializable;
import java.util.Date;
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
public class RoleMenuRelationVO extends TblRoleMenuRelation implements Serializable {
    private static final long serialVersionUID = 2277122435066595162L;

    private List childrenList;

    public RoleMenuRelationVO() {
    }

    public RoleMenuRelationVO(String createUser, Date createTime, String updateUser, Date updateTime, String id,
                              String roleId, String menuId, String remark, String delTag, List childrenList) {
        super(createUser, createTime, updateUser, updateTime, id, roleId, menuId, remark, delTag);
        this.childrenList = childrenList;
    }

    public List getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        return "RoleMenuRelationVO{" + JSONObject.toJSONString(this) + "}";
    }
}

package com.test.api.api.vo.userrolerelation;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblRoleUserRelation;

import java.io.Serializable;
import java.util.Date;
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
public class UserRoleRelationVO extends TblRoleUserRelation implements Serializable {

    private static final long serialVersionUID = 523734233729739297L;
    private List childrenList;

    public UserRoleRelationVO() {
    }

    public UserRoleRelationVO(String createUser, Date createTime, String updateUser, Date updateTime, String id,
                              String roleId, String userId, String remark, String delTag, List childrenList) {
        super(createUser, createTime, updateUser, updateTime, id, roleId, userId, remark, delTag);
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
        return "UserRoleRelationVO{" + JSONObject.toJSONString(this) + "}";
    }
}

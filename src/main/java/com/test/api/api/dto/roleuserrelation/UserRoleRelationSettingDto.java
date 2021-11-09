package com.test.api.api.dto.roleuserrelation;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.rolemenurelation
 * @className RoleMenuRelationSettingDto
 * @description 用户角色设置表单对象
 * @auther wangsheng
 * @creatTime 2021/10/14 1:16 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class UserRoleRelationSettingDto implements Serializable {

    private static final long serialVersionUID = -3202293337357528662L;
    /**
     * 菜单主键
     */
    @NotNull(message = "用户主键不能为空")
    @NotBlank(message = "用户主键不能为空")
    private String userId;
    /**
     * 数据操作ID列表
     */
    private String[] roleIdList;

    public UserRoleRelationSettingDto(@NotNull(message = "用户主键不能为空") @NotBlank(message = "用户主键不能为空") String usertId,
                                      String[] roleIdList) {
        this.userId = userId;
        this.roleIdList = roleIdList;
    }

    public UserRoleRelationSettingDto() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(String[] roleIdList) {
        this.roleIdList = roleIdList;
    }

    @Override
    public String toString() {
        return "UserRoleRelationSettingDto{"+ JSONObject.toJSONString(this) +"}";
    }
}

package com.test.api.api.dto.rolemanager;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.rolemanager
 * @className TblRoleDto
 * @description 添加角色控制器对象
 * @auther wangsheng
 * @creatTime 2021/10/5 2:18 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class TblRoleDto implements Serializable {
    private static final long serialVersionUID = -6051306325137183341L;

    /**
     * 角色名称
     */
    @NotNull(message = "角色不能为空")
    @NotBlank(message = "角色不能为空")
    private String name;

    public TblRoleDto() {
    }

    public TblRoleDto(@NotNull(message = "角色不能为空") @NotBlank(message = "角色不能为空") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TblRoleDto{" + JSONObject.toJSONString(this).toString() + '}';
    }
}

package com.test.api.api.dto.menudataoperaterelationmanager;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.menudataoperaterelationmanager
 * @className MenuDataOperateRelationSettingDto
 * @description 菜单数据操作权限设置表单对象
 * @auther wangsheng
 * @creatTime 2021/10/14 1:16 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class MenuDataOperateRelationSettingDto implements Serializable {
    private static final long serialVersionUID = 4963242540822315554L;

    /**
     * 菜单主键
     */
    @NotNull(message = "菜单主键不能为空")
    @NotBlank(message = "菜单主键不能为空")
    private String menuId;
    /**
     * 数据操作ID列表
     */
    private String[] dataOperateList;

    public MenuDataOperateRelationSettingDto(@NotNull(message = "菜单主键不能为空") @NotBlank(message = "菜单主键不能为空") String menuId, String[] dataOperateList) {
        this.menuId = menuId;
        this.dataOperateList = dataOperateList;
    }

    public MenuDataOperateRelationSettingDto() {
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String[] getDataOperateList() {
        return dataOperateList;
    }

    public void setDataOperateList(String[] dataOperateList) {
        this.dataOperateList = dataOperateList;
    }

    @Override
    public String toString() {
        return "MenuDataOperateRelationSettingDto{"+ JSONObject.toJSONString(this) +"}";
    }
}

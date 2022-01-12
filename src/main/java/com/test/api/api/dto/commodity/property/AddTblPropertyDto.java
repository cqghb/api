package com.test.api.api.dto.commodity.property;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.dto.BaseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.property
 * @className AddTblPropertyDto
 * @description 添加产品属性表单对象
 * @auther wangsheng
 * @creatTime 2022/1/13 上午1:21
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class AddTblPropertyDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -2963571958367122051L;
    /**
     * 属性ID
     */
    private String id;

    /**
     * 属性名称
     */
    @NotNull(message = "产品属性名称不能为空")
    @NotBlank(message = "产品属性名称不能为空")
    private String name;

    /**
     * 分类ID
     */
    @NotNull(message = "分类ID不能为空")
    @NotBlank(message = "分类ID不能为空")
    private String typeId;

    public AddTblPropertyDto() {
    }

    public AddTblPropertyDto(String remark, String delTag, String id,
                             @NotNull(message = "产品属性名称不能为空") @NotBlank(message = "产品属性名称不能为空") String name,
                             @NotNull(message = "分类ID不能为空") @NotBlank(message = "分类ID不能为空") String typeId) {
        super(remark, delTag);
        this.id = id;
        this.name = name;
        this.typeId = typeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "AddTblPropertyDto{" + JSONObject.toJSONString(this) + "}";
    }
}

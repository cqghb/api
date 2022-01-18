package com.test.api.api.dto.commodity.propertyoption;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.dto.BaseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.propertyoption
 * @className AddTblPropertyOptionsDto
 * @description 设置属性值表单对象
 * @auther wangsheng
 * @creatTime 2022/1/19 上午12:16
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class AddTblPropertyOptionsDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -5543673915822009656L;

    /**
     * 属性选项ID
     */
    private String id;

    /**
     * 选项值
     */
    @NotNull(message = "产品属性值不能为空")
    @NotBlank(message = "产品属性值不能为空")
    private String value;

    /**
     * 属性ID
     */
//    @NotNull(message = "产品属性名称不能为空")
//    @NotBlank(message = "产品属性名称不能为空")
    private String attrId;

    public AddTblPropertyOptionsDto() {
    }

    public AddTblPropertyOptionsDto(String remark, String delTag, String id,
                                    @NotNull(message = "产品属性值不能为空") @NotBlank(message = "产品属性值不能为空") String value,
                                    /*@NotNull(message = "产品属性名称不能为空") @NotBlank(message = "产品属性名称不能为空") */String attrId) {
        super(remark, delTag);
        this.id = id;
        this.value = value;
        this.attrId = attrId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    @Override
    public String toString() {
        return "AddTblPropertyOptionsDto{" + JSONObject.toJSONString(this) + "}";
    }
}

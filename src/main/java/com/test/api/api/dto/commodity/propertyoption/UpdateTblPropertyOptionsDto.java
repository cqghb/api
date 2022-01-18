package com.test.api.api.dto.commodity.propertyoption;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.dto.BaseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.propertyoption
 * @className UpdateTblPropertyOptionsDto
 * @description 维护产品属性值表单对象
 * @auther wangsheng
 * @creatTime 2022/1/19 上午12:40
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class UpdateTblPropertyOptionsDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -3653358327173422200L;

    /**
     * 属性选项ID
     */
    @NotNull(message = "产品属性值ID不能为空")
    @NotBlank(message = "产品属性值ID不能为空")
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
    private String attrId;

    public UpdateTblPropertyOptionsDto() {
    }

    public UpdateTblPropertyOptionsDto(String remark, String delTag,
                                       @NotNull(message = "产品属性值ID不能为空") @NotBlank(message = "产品属性值ID不能为空") String id
            , @NotNull(message = "产品属性值不能为空") @NotBlank(message = "产品属性值不能为空") String value, String attrId) {
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
        return "UpdateTblPropertyOptionsDto{" + JSONObject.toJSONString(this) + "}";
    }
}

package com.test.api.api.dto;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto
 * @className BaseDto
 * @description 表单基础类
 * @auther wangsheng
 * @creatTime 2022/1/4 下午1:09
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class BaseDto implements Serializable {
    private static final long serialVersionUID = 4883794572655084056L;
    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标志
     */
    private String delTag;

    public BaseDto() {
    }

    public BaseDto(String remark, String delTag) {
        this.remark = remark;
        this.delTag = delTag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDelTag() {
        return delTag;
    }

    public void setDelTag(String delTag) {
        this.delTag = delTag;
    }

    @Override
    public String toString() {
        return "BaseDto{" + JSONObject.toJSONString(this) + "}";
    }
}

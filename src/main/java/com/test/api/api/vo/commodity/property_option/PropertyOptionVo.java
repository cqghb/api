package com.test.api.api.vo.commodity.property_option;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblPropertyOptions;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.property_option
 * @className PropertyOptionVo
 * @description 产品属性值列表视图对象
 * @auther wangsheng
 * @creatTime 2022/1/18 上午12:20
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class PropertyOptionVo extends TblPropertyOptions implements Serializable {
    private static final long serialVersionUID = -6834760336236234799L;

    /**
     * 产品属性值对应的名称
     */
    private String propertyName;

    public PropertyOptionVo() {
    }

    public PropertyOptionVo(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                            String delTag, String id, String value, String attrId, String propertyName) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag, id, value, attrId);
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String toString() {
        return "PropertyOptionVo{" + JSONObject.toJSONString(this) + "}";
    }
}

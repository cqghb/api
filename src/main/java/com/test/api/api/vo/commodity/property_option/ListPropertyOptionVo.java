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
public class ListPropertyOptionVo extends TblPropertyOptions implements Serializable {
    private static final long serialVersionUID = -6834760336236234799L;

    /**
     * 属性值ID-产品ID
     */
    private String id;
    /**
     * 产品ID
     */
    private String skuId;
    /**
     * 产品代码
     */
    private String code;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 产品属性名称
     */
    private String attrName;
    /**
     * 产品属性值
     */
    private String value;

    public ListPropertyOptionVo() {
    }

    public ListPropertyOptionVo(String createUser, Date createTime, String updateUser, Date updateTime,
                                String remark, String delTag, String id, String value, String attrId, String id1,
                                String skuId, String code, String name, String attrName, String value1) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag, id, value, attrId);
        this.id = id1;
        this.skuId = skuId;
        this.code = code;
        this.name = name;
        this.attrName = attrName;
        this.value = value1;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropertyOptionVo{" + JSONObject.toJSONString(this) + "}";
    }
}

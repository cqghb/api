package com.test.api.api.vo.commodity.skupropertyoption;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSkuPropertyOption;
import com.test.api.api.vo.commodity.property_option.PropertyOptionVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.skupropertyoption
 * @className SkuPropertyOptionVO
 * @description 产品属性详情视图对象
 * @auther wangsheng
 * @creatTime 2022/1/24 上午12:43
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class SkuPropertyOptionVO extends TblSkuPropertyOption implements Serializable {
    private static final long serialVersionUID = 4062152762940940741L;

    /**
     * 产品ID-产品名称
     */
    private String skuIdName;

    /**
     * 产品属性列表
     */
    private List<PropertyOptionVo> listProperty;

    /**
     * 属性值ID-属性值
     */
    private String proOptIdName;

    public SkuPropertyOptionVO() {
    }

    public SkuPropertyOptionVO(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                               String delTag, String id, String skuId, String proOptId, String skuIdName,
                               List<PropertyOptionVo>  listProperty, String proOptIdName) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag, id, skuId, proOptId);
        this.skuIdName = skuIdName;
        this.listProperty = listProperty;
        this.proOptIdName = proOptIdName;
    }

    public String getSkuIdName() {
        return skuIdName;
    }

    public void setSkuIdName(String skuIdName) {
        this.skuIdName = skuIdName;
    }

    public List<PropertyOptionVo> getListProperty() {
        return listProperty;
    }

    public void setListProperty(List<PropertyOptionVo> listProperty) {
        this.listProperty = listProperty;
    }

    public String getProOptIdName() {
        return proOptIdName;
    }

    public void setProOptIdName(String proOptIdName) {
        this.proOptIdName = proOptIdName;
    }

    @Override
    public String toString() {
        return "SkuPropertyOptionVO{" + JSONObject.toJSONString(this) + "}";
    }
}

package com.test.api.api.vo.commodity.skuspecificationoption;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.BaseBean;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.skuspecificationoption
 * @className SkuSpecificationOptionVO
 * @description 产品规格选项配置试图对象
 * @auther wangsheng
 * @creatTime 2022/4/19 上午12:38
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class SkuSpecificationOptionVO extends BaseBean implements Serializable {
    private static final long serialVersionUID = 104113708598305786L;

    /**
     * 产品主键
     */
    private String skuId;
    /**
     * 产品代码
     */
    private String skuCode;
    /**
     * 产品名称
     */
    private String skuName;
    /**
     * 规格主键
     */
    private String id;
    /**
     * 规格名称
     */
    private String specName;
    /**
     * 规格选项ID
     */
    private String specOptiId;
    /**
     * 规格选项值
     */
    private String specOptiValue;


    public SkuSpecificationOptionVO() {
    }

    public SkuSpecificationOptionVO(String createUser, Date createTime, String updateUser, Date updateTime,
                                    String remark, String delTag, String skuId, String skuCode, String skuName,
                                    String id, String specName, String specOptiId, String specOptiValue) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.skuId = skuId;
        this.skuCode = skuCode;
        this.skuName = skuName;
        this.id = id;
        this.specName = specName;
        this.specOptiId = specOptiId;
        this.specOptiValue = specOptiValue;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecOptiId() {
        return specOptiId;
    }

    public void setSpecOptiId(String specOptiId) {
        this.specOptiId = specOptiId;
    }

    public String getSpecOptiValue() {
        return specOptiValue;
    }

    public void setSpecOptiValue(String specOptiValue) {
        this.specOptiValue = specOptiValue;
    }

    @Override
    public String toString() {
        return "SkuSpecificationOptionVO{"+ JSONObject.toJSONString(this)+"}";
    }
}

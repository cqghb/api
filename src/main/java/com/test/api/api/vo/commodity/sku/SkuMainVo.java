package com.test.api.api.vo.commodity.sku;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSku;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.sku
 * @className SkuMainVo
 * @description 产品列表也表单视图对象，显示比较重要的字段，比较全面
 * @auther wangsheng
 * @creatTime 2022/5/3 下午11:01
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class SkuMainVo extends TblSku implements Serializable {
    private static final long serialVersionUID = 5369861084550121322L;

    /**
     * 产品编码-名称
     */
    private String skuCodeName;
    /**
     * 货品编码
     */
    private String spuCode;
    /**
     * 货品名称
     */
    private String spuName;
    /**
     * 货品编码-名称
     */
    private String spuCodeName;
    /**
     * 品牌ID
     */
    private String brandId;
    /**
     * 品牌编码
     */
    private String brandCode;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 品牌编码-名称
     */
    private String brandCodeName;
    /**
     * 货品类型ID
     */
    private String spuTypeId;
    /**
     * 货品类型编码
     */
    private String spuTypeCode;
    /**
     * 货品类型名称
     */
    private String spuTypeName;
    /**
     * 货品类型编码-名称
     */
    private String spuTypeCodeName;
    /**
     * 产品规格ID
     */
    private String speId;
    /**
     * 产品规格名称
     */
    private String speName;
    /**
     * 产品规格ID-名称
     */
    private String speIdName;

    public SkuMainVo() {
    }

    public SkuMainVo(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                     String delTag, String id, String name, String code, BigDecimal price, int skuNumber,String spuId,
                     String skuCodeName, String spuCode, String spuName, String spuCodeName, String brandId,
                     String brandCode, String brandName, String brandCodeName, String spuTypeId, String spuTypeCode,
                     String spuTypeName, String spuTypeCodeName, String speId, String speName, String speIdName) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag, id, name, code, price, skuNumber, spuId);
        this.skuCodeName = skuCodeName;
        this.spuCode = spuCode;
        this.spuName = spuName;
        this.spuCodeName = spuCodeName;
        this.brandId = brandId;
        this.brandCode = brandCode;
        this.brandName = brandName;
        this.brandCodeName = brandCodeName;
        this.spuTypeId = spuTypeId;
        this.spuTypeCode = spuTypeCode;
        this.spuTypeName = spuTypeName;
        this.spuTypeCodeName = spuTypeCodeName;
        this.speId = speId;
        this.speName = speName;
        this.speIdName = speIdName;
    }

    public String getSkuCodeName() {
        return skuCodeName;
    }

    public void setSkuCodeName(String skuCodeName) {
        this.skuCodeName = skuCodeName;
    }

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSpuCodeName() {
        return spuCodeName;
    }

    public void setSpuCodeName(String spuCodeName) {
        this.spuCodeName = spuCodeName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandCodeName() {
        return brandCodeName;
    }

    public void setBrandCodeName(String brandCodeName) {
        this.brandCodeName = brandCodeName;
    }

    public String getSpuTypeId() {
        return spuTypeId;
    }

    public void setSpuTypeId(String spuTypeId) {
        this.spuTypeId = spuTypeId;
    }

    public String getSpuTypeCode() {
        return spuTypeCode;
    }

    public void setSpuTypeCode(String spuTypeCode) {
        this.spuTypeCode = spuTypeCode;
    }

    public String getSpuTypeName() {
        return spuTypeName;
    }

    public void setSpuTypeName(String spuTypeName) {
        this.spuTypeName = spuTypeName;
    }

    public String getSpuTypeCodeName() {
        return spuTypeCodeName;
    }

    public void setSpuTypeCodeName(String spuTypeCodeName) {
        this.spuTypeCodeName = spuTypeCodeName;
    }

    public String getSpeId() {
        return speId;
    }

    public void setSpeId(String speId) {
        this.speId = speId;
    }

    public String getSpeName() {
        return speName;
    }

    public void setSpeName(String speName) {
        this.speName = speName;
    }

    public String getSpeIdName() {
        return speIdName;
    }

    public void setSpeIdName(String speIdName) {
        this.speIdName = speIdName;
    }

    @Override
    public String toString() {
        return "SkuMainVo{" + JSONObject.toJSONString(this) + "}";
    }
}

package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_spu_brand 商品品牌表实体
 *
 * @author wsheng
 */
public class TblSpuBrand extends BaseBean implements Serializable {

    private static final long serialVersionUID = -817195323831010505L;
    /**
     * 品牌ID
     */
    private String id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌编码
     */
    private String code;


    public TblSpuBrand() {
    }


    public TblSpuBrand(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                       String delTag, String id, String name, String code) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TblSpuBrand{" + JSONObject.toJSONString(this) + "}";
    }
}
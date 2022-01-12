package com.test.api.api.vo.commodity.property;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.property
 * @className PropertyVo
 * @description 产品属性详细信息
 * @auther wangsheng
 * @creatTime 2022/1/13 上午1:37
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class PropertyVo extends TblProperty implements Serializable {
    private static final long serialVersionUID = -8347152780339279502L;
    /* 货品类型名称 */
    private String typeIdName;

    public PropertyVo() {
    }

    public PropertyVo(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                      String delTag, String id, String name, String typeId, String typeIdName) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag, id, name, typeId);
        this.typeIdName = typeIdName;
    }

    public String getTypeIdName() {
        return typeIdName;
    }

    public void setTypeIdName(String typeIdName) {
        this.typeIdName = typeIdName;
    }

    @Override
    public String toString() {
        return "PropertyVo{" + JSONObject.toJSONString(this) + "}";
    }
}

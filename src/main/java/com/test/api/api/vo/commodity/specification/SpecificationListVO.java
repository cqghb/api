package com.test.api.api.vo.commodity.specification;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSpecification;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity
 * @className SpecificationVO
 * @description 产品规格管理列表视图对象
 * @auther wangsheng
 * @creatTime 2022/1/5 上午1:33
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class SpecificationListVO extends TblSpecification implements Serializable {

    private static final long serialVersionUID = -673810591275147981L;
    /**
     * 规格组ID-名称
     */
    private String groupIdName;

    /**
     * 分类ID-名称
     */
    private String typeIdName;

    public SpecificationListVO() {
    }

    public SpecificationListVO(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                               String delTag, String id, String name, String groupId, String typeId, String addr,
                               String groupIdName, String typeIdName) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag, id, name, groupId, typeId, addr);
        this.groupIdName = groupIdName;
        this.typeIdName = typeIdName;
    }

    public String getGroupIdName() {
        return groupIdName;
    }

    public void setGroupIdName(String groupIdName) {
        this.groupIdName = groupIdName;
    }

    public String getTypeIdName() {
        return typeIdName;
    }

    public void setTypeIdName(String typeIdName) {
        this.typeIdName = typeIdName;
    }

    @Override
    public String toString() {
        return "SpecificationVO{" + JSONObject.toJSONString(this) + "}";
    }
}

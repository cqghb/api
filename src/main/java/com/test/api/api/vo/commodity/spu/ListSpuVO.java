package com.test.api.api.vo.commodity.spu;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblSpu;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.spu
 * @className ListSpuVO
 * @description 货品管理-货品列表展示对象
 * @auther wangsheng
 * @creatTime 2022/4/27 上午12:43
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class ListSpuVO extends TblSpu implements Serializable {
    private static final long serialVersionUID = -5788405881059158828L;

    /**
     * 货品所属类型
     */
    private String typeName;
    /**
     * 货品所属品牌
     */
    private String brandName;

    public ListSpuVO() {
    }

    public ListSpuVO(String createUser, Date createTime, String updateUser, Date updateTime, String remark,
                     String delTag, String id, String name, String code, String briefIntroduction, String detail,
                     String typeId, String brandId, String typeName, String brandName) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag, id, name, code, briefIntroduction,
                detail, typeId, brandId);
        this.typeName = typeName;
        this.brandName = brandName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "ListSpuVO{" + JSONObject.toJSONString(this) + "}";
    }
}

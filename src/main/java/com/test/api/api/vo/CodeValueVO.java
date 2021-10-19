package com.test.api.api.vo;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblDataOperate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo
 * @className CodeValueVO
 * @description 菜单数据操作权限数据显示对象
 * @auther wangsheng
 * @creatTime 2021/10/16 10:08 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class CodeValueVO extends TblDataOperate implements Serializable {

    private List childrenList;

    public CodeValueVO() {
    }

    public CodeValueVO(String createUser, Date createTime, String updateUser, Date updateTime, String id, String name
            , String operateAddr, String remark, String delTag, String subgroup, List childrenList) {
        super(createUser, createTime, updateUser, updateTime, id, name, operateAddr, remark, delTag, subgroup);
        this.childrenList = childrenList;
    }

    public List getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        return "CodeValueVO{" + JSONObject.toJSONString(this) + "}";
    }
}

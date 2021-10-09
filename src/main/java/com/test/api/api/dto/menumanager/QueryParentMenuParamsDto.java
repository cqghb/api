package com.test.api.api.dto.menumanager;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblMenu;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.dto.menumanager
 * @className QueryParentMenuParamsDto
 * @description 查询父节点的查询条件
 * @auther wangsheng
 * @creatTime 2021/9/24 1:19 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class QueryParentMenuParamsDto extends TblMenu implements Serializable {
    /**
     * 本节点ID
     */
    private String theId;

    public QueryParentMenuParamsDto() {
    }

    public QueryParentMenuParamsDto(String createUser, Date createTime, String updateUser, Date updateTime, String id
            , String name, String icon, String parentNode, String defaultSelect, String uri,
                                    List<String> defaultSelectList, List<TblMenu> childrenList, String theId, String remark, String delTag) {
        super(createUser, createTime, updateUser, updateTime, id, name, icon, parentNode, defaultSelect, uri,
                defaultSelectList, childrenList, remark, delTag);
        this.theId = theId;
    }

    public String getTheId() {
        return theId;
    }

    public void setTheId(String theId) {
        this.theId = theId;
    }

    @Override
    public String toString() {
        return "QueryParentMenuParamsDto{" + JSONObject.toJSONString(this).toString() + "}";
    }
}

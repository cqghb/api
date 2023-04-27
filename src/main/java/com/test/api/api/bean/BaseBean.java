package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.bean
 * @className BaseBean
 * @description 表实体对象基类
 * @auther wangsheng
 * @creatTime 2020/11/7 7:27 下午
 * @company demo
 * @department demo
 */
@Data
public class BaseBean implements java.io.Serializable {
    private static final long serialVersionUID = 9187795641769154646L;
    // 创建人
    private String createUser;
    // 创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    // 修改人
    private String updateUser;
    // 修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标志[1: 删除; 2: 保留]
     */
    private String delTag;

    @Override
    public String toString() {
        return "BaseBean{" + JSONObject.toJSONString(this) +'}';
    }
}

package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

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
     * 删除标志
     */
    private String delTag;

    public BaseBean() {
    }

    public BaseBean(String createUser, Date createTime, String updateUser, Date updateTime, String remark, String delTag) {
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.remark = remark;
        this.delTag = delTag;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDelTag() {
        return delTag;
    }

    public void setDelTag(String delTag) {
        this.delTag = delTag;
    }

    @Override
    public String toString() {
        return "BaseBean{" + JSONObject.toJSONString(this) +'}';
    }
}

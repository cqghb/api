package com.test.api.api.bean;

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
    // 创建人
    private String createUser;
    // 创建时间
    private Date createTime;
    // 修改人
    private String updateUser;
    // 修改时间
    private Date updateTime;

    public BaseBean() {
    }

    public BaseBean(String createUser, Date createTime, String updateUser, Date updateTime) {
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
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

    @Override
    public String toString() {
        return "BaseBean{" +
                "createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}

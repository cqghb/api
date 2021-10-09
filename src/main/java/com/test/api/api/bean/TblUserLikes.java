package com.test.api.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_user_likes
 * 用户喜好表
 * @author 
 */
public class TblUserLikes extends BaseBean implements Serializable {
    /**
     * 爱好主键
     */
    private String id;

    /**
     * 爱好代码
     */
    private String titleCode;

    /**
     * 用户主键
     */
    private String userId;

    private static final long serialVersionUID = 1L;

    public TblUserLikes() {
    }

    public TblUserLikes(String createUser, Date createTime, String updateUser, Date updateTime, String id,
                        String titleCode, String userId, String remark, String delTag) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.titleCode = titleCode;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TblUserLikes{" +
                "id='" + id + '\'' +
                ", titleCode='" + titleCode + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * tbl_user_likes
 * 用户喜好表
 * @author 
 */
@Data
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

}
package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_user
 * @author 
 */
@Data
public class TblUser extends BaseBean implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String pass;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * qq号
     */
    private String qq;

    /**
     * 微信号
     */
    private String weChat;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 学历
     */
    private String education;
    /**
     * 头像地址
     */
    private String headPortraitUrl;

    private static final long serialVersionUID = 1L;

}
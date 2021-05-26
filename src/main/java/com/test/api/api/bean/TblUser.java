package com.test.api.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_user
 * @author 
 */
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

    public TblUser() {
    }

    public TblUser(String createUser, Date createTime, String updateUser, Date updateTime, String id, String name, String pass, Integer age, String sex, Date birthday, String qq, String weChat, String email, String education) {
        super(createUser, createTime, updateUser, updateTime);
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.qq = qq;
        this.weChat = weChat;
        this.email = email;
        this.education = education;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    @Override
    public String toString() {
        return "TblUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", qq='" + qq + '\'' +
                ", weChat='" + weChat + '\'' +
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", headPortraitUrl='" + headPortraitUrl + '\'' +
                '}';
    }
}
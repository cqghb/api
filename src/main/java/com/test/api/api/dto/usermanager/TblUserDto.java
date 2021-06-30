package com.test.api.api.dto.usermanager;

import com.test.api.api.utils.JsonUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.dto.usermanager
 * @className TblUserDto
 * @description 用户数据传输对象
 * @auther wangsheng
 * @creatTime 2021/6/30 11:38 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class TblUserDto implements Serializable {

    private static final long serialVersionUID = -8083044189671431684L;

    /**
     * 主键
     */
    private String id;

    /**
     * 姓名
     */
    @NotNull(message = "姓名不能为空")
    @NotBlank(message = "姓名不能为空")
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
    @NotBlank(message = "邮箱不能为空")
    @NotNull(message = "邮箱不能为空")
    private String email;

    /**
     * 学历
     */
    @NotBlank(message = "{education.not.null}")
    @NotNull(message = "{education.not.null}")
    private String education;
    /**
     * 头像地址
     */
    private String headPortraitUrl;

    public TblUserDto() {
    }

    public TblUserDto(String id, @NotNull(message = "姓名不能为空") @NotBlank(message = "姓名不能为空") String name, String pass, Integer age, String sex, Date birthday, String qq, String weChat, @NotBlank(message = "邮箱不能为空") @NotNull(message = "邮箱不能为空") String email, @NotBlank(message = "{education.not.null}") @NotNull(message = "{education.not.null}") String education, String headPortraitUrl) {
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
        this.headPortraitUrl = headPortraitUrl;
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
        return "TblUserDto{" + JsonUtils.objectToJson(this) + "}";
    }
}

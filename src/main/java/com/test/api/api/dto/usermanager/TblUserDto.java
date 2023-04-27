package com.test.api.api.dto.usermanager;

import lombok.Data;

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
@Data
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

    // 喜好
    String[] likes;
}

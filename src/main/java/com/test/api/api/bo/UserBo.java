package com.test.api.api.bo;

import com.test.api.api.bean.TblUser;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.bo
 * @className UserBo
 * @description
 * @auther wangsheng
 * @creatTime 2021/5/17 10:15 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class UserBo extends TblUser implements Serializable {
    // 喜好
    String[] likes;
    // 确认密码
    String pass2;
    // 验证码
    String verificationCode;
}

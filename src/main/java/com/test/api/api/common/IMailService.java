package com.test.api.api.common;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ImailService
 * @description 邮件发送接口
 * @auther wangsheng
 * @creatTime 2021/6/15 11:46 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface IMailService {
    /**
     * 向指定邮箱发送验证码
     * @param toEmail 邮箱
     * @return
     */
    String sendVerificationCode(String toEmail);
}

package com.test.api.api.action;

import com.test.api.api.config.Result;
import com.test.api.api.common.IMailService;
import com.test.api.api.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName api
 * @package com.test.api.api.action
 * @className MailController
 * @description 邮件发送控制器
 * @auther wangsheng
 * @creatTime 2021/6/15 11:57 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@RestController
@RequestMapping("mail")
public class MailControl {

    @Autowired
    private IMailService mailService;

    /**
     * 发送验证码
     * @param phoneEmail 目标邮箱
     * @return
     */
    @GetMapping(value="/sendVerificationCode")
    public Result sendVerificationCode(@RequestParam("phoneEmail") String phoneEmail) {
        String verCode = mailService.sendVerificationCode(phoneEmail);
        return ResultUtil.success(verCode);
    }
}

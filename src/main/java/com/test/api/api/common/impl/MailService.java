package com.test.api.api.common.impl;

import com.test.api.api.common.IMailService;
import com.test.api.api.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className MailService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/6/15 11:49 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Component
public class MailService implements IMailService {

    protected static final Logger logger = LoggerFactory.getLogger(MailService.class);

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sendVerificationCode(String toEmail) {
        //简单邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String code = StringUtil.getRandNum(6);
        logger.info("验证码: " + code);
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("验证码");
        simpleMailMessage.setText(code);
        try{
            mailSender.send(simpleMailMessage);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return null;
        }
        return code;
    }
}

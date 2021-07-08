package com.test.api.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * @projectName api
 * @package com.test.api.api.config
 * @className ValidationConfig
 * @description Validation校验配置
 * @auther wangsheng
 * @creatTime 2021/7/9 1:51 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Configuration
public class ValidationConfig {

    @Bean
    public Validator getValidator(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // 指定配置文件路径以及名字
        messageSource.setBasename("i18n/validation/ValidationMessages_zh");
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource);
        return validator;
    }
}

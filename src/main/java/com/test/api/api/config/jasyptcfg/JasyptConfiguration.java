package com.test.api.api.config.jasyptcfg;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @projectName api
 * @package com.test.api.api.config.jasyptcfg
 * @className JasyptConfiguration
 * @description Jasypt配置
 * @auther wangsheng
 * @creatTime 2021/6/16 1:06 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Configuration
public class JasyptConfiguration {

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor(Environment environment){
        return new MyJasyptStringEncryptor(environment);
    }
}

package com.test.api.api.config.jasyptcfg;

import org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.PBEConfig;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import java.nio.charset.StandardCharsets;

/**
 * @projectName api
 * @package com.test.api.api.config.jasyptcfg
 * @className MyJasyptStringEncryptor
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/6/16 1:09 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class MyJasyptStringEncryptor implements StringEncryptor {

    protected static final Logger logger = LoggerFactory.getLogger(MyJasyptStringEncryptor.class);

    private final StandardPBEByteEncryptor byteEncryptor;
    private final Base64 base64;

//    public MyJasyptStringEncryptor() {
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//        config.setPassword("EdLKOREFDMI/sddnc@A");
//        config.setAlgorithm("PBEWithMD5AndDES");
//        this.byteEncryptor = new StandardPBEByteEncryptor();
//        this.byteEncryptor.setConfig(config);
//        this.base64 = new Base64();
//    }

    public MyJasyptStringEncryptor(Environment environment) {
        byteEncryptor = new StandardPBEByteEncryptor();
        byteEncryptor.setConfig(getConfig(environment));
        this.base64 = new Base64();
    }

    public MyJasyptStringEncryptor(StandardPBEByteEncryptor byteEncryptor, Base64 base64) {
        this.byteEncryptor = byteEncryptor;
        this.base64 = base64;
    }

    @Override
    public String encrypt(String s) {
        byte[] encrypt = byteEncryptor.encrypt((s).getBytes());
        byte[] encode = base64.encode(encrypt);
        return new String(encode, StandardCharsets.UTF_8);
    }

    @Override
    public String decrypt(String s) {
        byte[] decode = base64.decode(s.getBytes());
        byte[] decrypt  = byteEncryptor.decrypt(decode);
        return new String(decrypt,StandardCharsets.UTF_8);
    }

    private PBEConfig getConfig(Environment e){
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(getRequiredProperty(e, "jasypt.encryptor.password","1234567890qazwsxedc"));
        config.setAlgorithm(getProperty(e, "jasypt.encryptor.algorithm", "PBEWithMD5AndDES"));
        config.setKeyObtentionIterations(getProperty(e, "jasypt.encryptor.keyObtentionIterations", "1000"));
        config.setPoolSize(getProperty(e, "jasypt.encryptor.poolSize", "1"));
        config.setProviderName(getProperty(e, "jasypt.encryptor.providerName", null));
        config.setSaltGeneratorClassName(getProperty(e, "jasypt.encryptor.saltGeneratorClassname", "org.jasypt.salt.RandomSaltGenerator"));
        config.setStringOutputType(getProperty(e, "jasypt.encryptor.stringOutputType", "base64"));
        return config;
    }

    private static String getProperty(Environment environment, String key, String defaultValue) {
        if (!propertyExists(environment, key)) {
            logger.info("Encryptor config not found for property {}, using default value: {}", key, defaultValue);
        }
        return environment.getProperty(key, defaultValue);
    }

    private static boolean propertyExists(Environment environment, String key) {
        return environment.getProperty(key) != null;
    }

    private static String getRequiredProperty(Environment environment, String key, String defaultValue) {
        if (!propertyExists(environment, key)) {
            logger.info("Encryptor config not found for property {}, using default value: {}", key, defaultValue);
        }
        return environment.getProperty(key,defaultValue);
    }
}

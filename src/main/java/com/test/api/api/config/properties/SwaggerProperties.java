package com.test.api.api.config.properties;

import com.test.api.api.utils.JsonUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @projectName api
 * @package com.test.api.api.config.properties
 * @className SwaggerProperties
 * @description Swagger配置实体类
 * @auther wangsheng
 * @creatTime 2021/6/20 3:02 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Component
@ConfigurationProperties("swagger")
public class SwaggerProperties {
    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    private Boolean enable;
    /**
     * 项目应用名
     */
    private String applicationName;
    /**
     * 项目版本信息
     */
    private String applicationVersion;
    /**
     * 项目描述信息
     */
    private String applicationDescription;
    /**
     * 接口调试地址
     */
    private String tryHost;

    public SwaggerProperties() {
    }

    public SwaggerProperties(Boolean enable, String applicationName, String applicationVersion, String applicationDescription, String tryHost) {
        this.enable = enable;
        this.applicationName = applicationName;
        this.applicationVersion = applicationVersion;
        this.applicationDescription = applicationDescription;
        this.tryHost = tryHost;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getApplicationDescription() {
        return applicationDescription;
    }

    public void setApplicationDescription(String applicationDescription) {
        this.applicationDescription = applicationDescription;
    }

    public String getTryHost() {
        return tryHost;
    }

    public void setTryHost(String tryHost) {
        this.tryHost = tryHost;
    }

    @Override
    public String toString() {
        return "SwaggerProperties{"+ JsonUtils.objectToJson(this) +"}";
    }
}

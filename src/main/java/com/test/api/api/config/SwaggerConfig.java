package com.test.api.api.config;

import com.test.api.api.config.properties.SwaggerProperties;
import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

/**
 * @projectName api
 * @package com.test.api.api.config
 * @className SwaggerConfig
 * @description Swagger配置
 * @auther wangsheng
 * @creatTime 2021/6/19 11:54 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    private final SwaggerProperties swaggerProperties;

    public SwaggerConfig(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .enable(swaggerProperties.getEnable())
                .host(swaggerProperties.getTryHost())//之前一直无法访问页面就是因为这个没有配置
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test.api.api.action"))
                .paths(PathSelectors.any())
                .build()
                .protocols(newHashSet("https", "http"))// 支持的通讯协议集合
                .securitySchemes(securitySchemes())// 授权信息设置，必要的header token等认证信息
                .securityContexts(securityContexts())// 授权信息全局应用
                ;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("api接口文档")
                .description("在这里可以查看所有接口，并测试接口的，测试暂时还没有测试")
                .termsOfServiceUrl("http://localhost:8081/")
                .version("1.0.0")
                .build();
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }

    /**
     * 设置授权信息
     */
    private List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey("BASE_TOKEN", "token", In.HEADER.toValue());
        return Collections.singletonList(apiKey);
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(Collections.singletonList(new SecurityReference("BASE_TOKEN", new AuthorizationScope[]{new AuthorizationScope("global", "")})))
                        .build()
        );
    }

//    /**
//     * 通用拦截器排除swagger设置，所有拦截器都会自动加swagger相关的资源排除信息
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        try {
//            Field registrationsField = FieldUtils.getField(InterceptorRegistry.class, "registrations", true);
//            List<InterceptorRegistration> registrations = (List<InterceptorRegistration>) ReflectionUtils.getField(registrationsField, registry);
//            if (registrations != null) {
//                for (InterceptorRegistration interceptorRegistration : registrations) {
//                    interceptorRegistration
//                            .excludePathPatterns("/swagger**/**")
//                            .excludePathPatterns("/webjars/**")
//                            .excludePathPatterns("/v3/**")
//                            .excludePathPatterns("/doc.html");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    /**
//     * 解决swagger-ui.html 404无法访问的问题
//     */
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 解决静态资源无法访问
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//        // 解决swagger无法访问
//        registry.addResourceHandler("/swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        // 解决swagger的js文件无法访问
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
}

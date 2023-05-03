package com.test.api.api.config;

import com.test.api.api.config.properties.SwaggerProperties;
import com.test.api.api.myinterceptor.CommonInterceptor;
import com.test.api.api.myinterceptor.PermissionVerificationInterceptor;
import com.test.api.api.myinterceptor.RedisSessionInterceptor;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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

    @Autowired
    private RedisSessionInterceptor redisSessionInterceptor;

    @Autowired
    private CommonInterceptor commonInterceptor;

    @Autowired
    private PermissionVerificationInterceptor permissionVerificationInterceptor;

    public SwaggerConfig(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

//    @Bean
//    public RedisSessionInterceptor getSessionInterceptor(){
//        return new RedisSessionInterceptor();
//    }
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
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /**
         * 所有已api开头的访问都要进入RedisSessionInterceptor拦截器进行登录验证，并排除login接口(全路径)。
         * 必须写成链式，分别设置的话会创建多个拦截器。拦截顺序不要修改
         * 必须写成getSessionInterceptor()，否则SessionInterceptor中的@Autowired会无效
         * http://127.0.0.1:8081/server/login
         * **/
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");// 这个拦截器拦截所有请求
        registry.addInterceptor(permissionVerificationInterceptor).addPathPatterns("/**");// 这个拦截器拦截所有请求
        registry.addInterceptor(redisSessionInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login")// 路径从controller开始，不要加/server
                .excludePathPatterns("/file/uploadFile")// TODO 上传图片暂时不要拦截了,注册的时候可能会上传图片
                .excludePathPatterns("/file/uploadFile")// TODO 删除图片暂时不要拦截了,可删除临时的商品图片
                .excludePathPatterns("/codeValue/searchCodeKeyValue")// TODO 上传图片暂时不要拦截了,注册的时候可能会上传图片
                .excludePathPatterns("/mail/sendVerificationCode")// TODO 上传图片暂时不要拦截了,注册的时候可能会上传图片
                .excludePathPatterns("/resetPass")
                .excludePathPatterns("/insertUser");
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:8080")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .maxAge(3600)
//                .exposedHeaders("Access-Control-Allow-Origin")
//                .allowCredentials(true);
//    }

//    @Bean
//    public CorsFilter corsFilter(){
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", this.buildConfig());
//        return new CorsFilter(source);
//    }
//
//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }
}

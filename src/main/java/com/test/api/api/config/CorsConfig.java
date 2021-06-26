//package com.test.api.api.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// * @projectName api
// * @package com.test.api.api.config
// * @className CorsConfig
// * @description 跨域配置
// * @auther wangsheng
// * @creatTime 2021/6/24 1:02 上午
// * @company 四川省万源市一生活智能科技有限公司
// * @department 小程序-微信小程序
// */
//@Configuration
//public class CorsConfig {
//
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
//}

package com.test.api.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@ComponentScan({"com.test.api.api.*"})
@MapperScan("com.test.api.api.dao")
@EnableOpenApi
@EnableTransactionManagement
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}

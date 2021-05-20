package com.test.api.api.custom.annotation;

import com.test.api.api.constant.CommConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解声明文件类型
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FileType {
    String value() default CommConstant.MENU_PRENT_NODE;
}

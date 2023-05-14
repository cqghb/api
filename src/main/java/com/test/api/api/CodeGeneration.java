package com.test.api.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @projectName api
 * @package com.test.api.api
 * @className CodeGeneration
 * @description TODO
 * @auther wangsheng
 * @creatTime 2023/5/6 上午1:16
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class CodeGeneration {

    public static void main(String[] args) {
        /**
         * 先配置数据源
         */
        MySqlQuery mySqlQuery = new MySqlQuery() {
            @Override
            public String[] fieldCustom() {
                return new String[]{"Default"};
            }
        };
        DataSourceConfig dsc = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/api?&useSSL=true&useUnicode" +
                "=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai","root","helloser")
                .dbQuery(mySqlQuery).build();
        //通过datasourceConfig创建AutoGenerator
        AutoGenerator generator = new AutoGenerator(dsc);

        /**
         * 全局配置
         */
        String projectPath = System.getProperty("user.dir"); //获取项目路径
        String filePath = projectPath + "/src/main/java";  //java下的文件路径
        GlobalConfig global = new GlobalConfig.Builder()
                .outputDir(filePath)//生成的输出路径
                .author("wsheng")//生成的作者名字
                .enableSwagger()//开启swagger，需要添加swagger依赖并配置
                .dateType(DateType.TIME_PACK)//时间策略
                .commentDate("yyyy-MM-dd")//格式化时间格式
                .disableOpenDir()//禁止打开输出目录，默认false
//                .fileOverride()//覆盖生成文件
                .build();

        /**
         * 包配置
         */
        PackageConfig packages = new PackageConfig.Builder()
                .parent("com.test.api.api")//父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                .controller("action")//控制层包名
                .service("service")//service层包名
                .serviceImpl("service.impl")//service实现类包名
                .entity("bean")//实体类包名
                .mapper("dao")//mapper层包名
//                .other("output")//输出自定义文件时的包名
                .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper"))// xml
                // 文件生成位置
//                .pathInfo(Collections.singletonMap(OutputFile.entity, projectPath + "/com/test/api/api/bean"))
                //路径配置信息,就是配置各个文件模板的路径信息,这里以mapper.xml为例
                .build();

        /**
         * 模板配置
         */

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
         // 如果模板引擎是 velocity
//         String templatePath = "/templates/entity.java";
        // 如果模板引擎是 freemarker
         String templatePath = "/templates/entity.java";
         String templateController = "/templates/controller.java";



        TemplateConfig template = new TemplateConfig.Builder()
//            .disable()//禁用所有模板
                .disable(TemplateType.ENTITY, TemplateType.CONTROLLER)// 禁用指定模板
                .entity(templatePath)// 这里不使用自定义模板的话bean的@TableId 格式有问题
//                .service("/service.java")// service模板路径
//                .serviceImpl("/service/impl/serviceImpl.java")//实现类模板路径
//                .mapper("/mapper.java")//mapper模板路径
//                .mapperXml("/templates/mapper.xml")//xml文件模板路路径
                .controller(templateController)//controller层模板路径
                .build();

        /**
         * 策略配置开始
         */
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .enableCapitalMode()//开启全局大写命名
                //.likeTable()模糊表匹配
                .addInclude("tbl_sku_comment_image","tbl_sku_comment")//添加表匹配，指定要生成的数据表名，不写默认选定数据库所有表
                //.disableSqlFilter()禁用sql过滤:默认(不使用该方法）true
                //.enableSchema()启用schema:默认false

                .entityBuilder() //实体策略配置
                //.disableSerialVersionUID()禁用生成SerialVersionUID：默认true
                .enableChainModel()//开启链式模型
                .enableLombok()//开启lombok
                .enableRemoveIsPrefix()//开启 Boolean 类型字段移除 is 前缀
                .enableTableFieldAnnotation()//开启生成实体时生成字段注解
                //.addTableFills()添加表字段填充
                .naming(NamingStrategy.underline_to_camel)//数据表映射实体命名策略：默认下划线转驼峰underline_to_camel
                .columnNaming(NamingStrategy.underline_to_camel)//表字段映射实体属性命名规则：默认null，不指定按照naming执行
                .idType(IdType.INPUT)//添加全局主键类型
                .formatFileName("%s")//格式化实体名称，%s取消首字母I
                .enableFileOverride()// 覆盖已有文件
                .logicDeleteColumnName("del_tag")// 逻辑删除字段名(数据库)
                .logicDeletePropertyName("delTag")// 逻辑删除属性名(实体)
                .build()

                .mapperBuilder()//mapper文件策略
                .enableMapperAnnotation()//开启mapper注解
                .enableBaseResultMap()//启用xml文件中的BaseResultMap 生成
                .enableBaseColumnList()//启用xml文件中的BaseColumnList
                //.cache(缓存类.class)设置缓存实现类
                .formatMapperFileName("%sDao")//格式化Dao类名称
                .formatXmlFileName("%sDao")//格式化xml文件名称
                .enableFileOverride()// 覆盖已有文件
                .build()

                .serviceBuilder()//service文件策略
                .formatServiceFileName("I%sService")//格式化 service 接口文件名称
                .formatServiceImplFileName("%sService")//格式化 service 接口文件名称
                .enableFileOverride()// 覆盖已有文件
                .build()

                .controllerBuilder()//控制层策略
                //.enableHyphenStyle()开启驼峰转连字符，默认：false
                .enableRestStyle()//开启生成@RestController
                .formatFileName("%sController")//格式化文件名称
                .enableFileOverride()// 覆盖已有文件
                .build();
        /**
         * 注入配置,自定义配置一个Map对象
         */
//    Map<String,Object> map = new HashMap<>();
//        map.put("name","young");
//        map.put("age","22");
//        map.put("sex","男");
//        map.put("description","深情不及黎治跃");
//
//    InjectionConfig injectionConfig = new InjectionConfig.Builder()
//            .customMap(map)
//            .build();

        /*至此，策略配置才算基本完成！*/
        generator.global(global)
                .template(template)
//                .injection(injectionConfig)
                .packageInfo(packages)
                .strategy(strategyConfig)
                .execute(new FreemarkerTemplateEngine());// 指定模板引擎

    }
}

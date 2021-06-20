package com.test.api.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.utils
 * @className JsonUtils
 * @description 与JSON相关操作工具类,使用jackson库
 * @auther wangsheng
 * @creatTime 2021/6/19 1:31 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class JsonUtils {

    protected static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    // 定义jackson对象
    public static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串
     * @param data 待转换对象
     * @return
     */
    public static String objectToJson(Object data){
        try {
            String str = MAPPER.writeValueAsString(data);
            return str;
        } catch (JsonProcessingException e) {
            logger.error("对象转JSON字符串转换失败: " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     * @param jsonStr 待转化的JSON字符串
     * @param beanType 转化之后的类型
     * @param <T>
     * @return
     */
    public static <T> T jsonToPojo(String jsonStr, Class<T> beanType){
        try {
            T t = MAPPER.readValue(jsonStr, beanType);
            return t;
        } catch (JsonProcessingException e) {
            logger.error("JSON字符串转对象失败: " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * @param jsonStr 待转化的JSON字符串
     * @param beanTyp 转化之后的类型
     * @param <T>
     * @return
     */
    public static <T>List<T> jsonToList(String jsonStr, Class<T> beanTyp){
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanTyp);

        try {
            List<T> list = MAPPER.readValue(jsonStr, javaType);
            return list;
        } catch (JsonProcessingException e) {
            logger.error("JSON字符串转List失败: " + e.getMessage(), e);
        }
        return null;
    }


}

package com.test.api.api.utils;

import com.test.api.api.constant.CommConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.UUID;

/**
 * @projectName api
 * @package com.test.api.api.utils
 * @className StringUtil
 * @description 字符串操作工具类
 * @auther wangsheng
 * @creatTime 2021/5/13 11:17 下午
 * @company
 * @department
 */
public class StringUtil {
    protected static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 随机生成6位数字字符串
     * @return
     */
    public static String getRandom(){
        int num = new Random().nextInt(999999);
        logger.info("随机生成的六位数是: " + num);
        if (num < 100000) {
            num += 100000;
        }
        logger.info("最终生成的六位数是: " + num);
        return String.valueOf(num);
    }

    /**
     * 生成32位的UUID，重复概率很小
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replace(CommConstant.HORIZONTAL_LINE,"").toUpperCase();
    }

    public static void main(String[] args) {
        logger.info(uuid());
    }
}

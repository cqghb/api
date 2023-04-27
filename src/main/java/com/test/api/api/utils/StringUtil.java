package com.test.api.api.utils;

import com.test.api.api.constant.CommConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

    /**
     * 生成charCount位验证码
     * @param charCount 验证码位数
     * @return
     */
    public static String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }

    /**
     * 判断对象是否为空
     * @param obj 待判断对象
     * @return
     */
    public static boolean objIsEmpty(Object obj){
        if(obj==null){
            return true;
        }
        if(obj instanceof List){
            return ((List) obj).size()==0;
        }
        if(obj instanceof String){
            return ((String) obj).trim().equals("");
        }
        return false;
    }
    /**
     * 判断对象是否不为空
     * @param obj 待判断对象
     * @return
     */
    public static boolean objIsNotEmpty(Object obj){
        return !objIsEmpty(obj);
    }

    /**
     * 生成编号
     * 生成规则: 时间(yyyyMMddHHmmssSSS)+4位随机数
     * @return
     */
    public static String getNo() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateStr = DateTimeFormatter.ofPattern(CommConstant.DATE_FORMATTER_1).format(localDateTime);
        String number = dateStr + String.valueOf(localDateTime.getNano() / 1000000) + getRandNum(4);
        return number;
    }

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        String  date= DateTimeFormatter.ofPattern(CommConstant.DATE_FORMATTER_1).format(dateTime);
        logger.info(date);
    }
}

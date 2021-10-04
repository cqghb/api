package com.test.api.api.constant;

/**
 * @projectName api
 * @package com.test.api.api.constant
 * @className CommConstant
 * @description 公共常量声明类
 * @auther wangsheng
 * @creatTime 2020/11/7 8:17 下午
 * @company demo
 * @department demo
 */
public class CommConstant {

    // 根菜单标识 即是parent_node值为0的就是根菜单
    public static final String MENU_PRENT_NODE = "0";
    // 横线
    public static final String HORIZONTAL_LINE = "-";
    // 下划线
    public static final String UNDERLINE = "_";
    // 点号
    public static final String DOT = ".";

    /** 文件类型常量 start **/
    // 头像文件
    public static final String FILE_TYPE_HEAD_PORTRAIT = "1";
    // 商品展示图片
    public static final String FILE_TYPE_PRODUCT_DISPLAY_PICTURE = "2";
    // excel文件
    public static final String FILE_TYPE_EXCELE = "3";

    /** 文件类型常量 end **/

    /** 公共常量 start **/
    // 用户信息存入Redis中的key
    public static final String REDIS_USER_KEY = "redisUserKey";
    // session ID
    public static final String JSESSIONID = "JSESSIONID";
    // 默认密码
    public static final String DEFAULT_PASSS = "666666";
    /** 公共常量 end **/

    /** 通过反射调用方法的方法名统一写到这里 start **/
    // 列表查询
    public static final String QUERY_LIST = "queryList";
    public static final String QUERY_PAGE_PARENT_MENU = "queryPageParentMenu";
    /** 通过反射调用方法的方法名统一写到这里 end **/
}

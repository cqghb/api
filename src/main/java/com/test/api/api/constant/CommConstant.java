package com.test.api.api.constant;

import java.util.Arrays;
import java.util.List;

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
    // utf8编码
    public static final String ENCODED_UTF8 = "UTF-8";
    // 内容类型
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    // 请求白名单
    public static final List<String> WHITE_LIST = Arrays.asList(new String[]{"/login", "/file/uploadFile",
            "/codeValue/searchCodeKeyValue", "/mail/sendVerificationCode", "/resetPass", "/insertUser", "/menu" +
            "/queryMenu"});

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
    // 用户数据操作权限存入Redis中的key
    public static final String REDIS_USER_DATA_OPER_KEY = "redisUserDataOperKey";
    // session ID
    public static final String JSESSIONID = "JSESSIONID";
    // 默认密码
    public static final String DEFAULT_PASSS = "666666";
    // 删除标记
    public static final String DEL_TAG = "delTag";
    public static final String UPDATE_USER = "updateUser";
    public static final String UPDATE_TIME = "updateTime";
    public static final String CREATE_USER = "createUser";
    public static final String CREATE_TIME = "createTime";
    /**
     * 产品默认版本号
     */
    public static final String PRO_VERSION = "v1.0";
    /**
     * 常量0
     */
    public static final String ZERO = "0";

    /** 公共常量 end **/

    /** 日期格式 start**/
    public static final String DATE_FORMATTER_1 = "yyyyMMddHHmmss";
    /** 日期格式 end**/

    /** 通过反射调用方法的方法名统一写到这里 start **/
    // 列表查询
    public static final String QUERY_LIST = "queryList";
    public static final String QUERY_PAGE_PARENT_MENU = "queryPageParentMenu";
    public static final String SELECT_BY_PRIMARY_KEY = "selectByPrimaryKey";
    public static final String QUERY_DATA_OPERATE_SUBGROUP = "queryDataOperateSubgroup";
    /** 通过反射调用方法的方法名统一写到这里 end **/

    /** 声明角色管理模块常量 start **/
    /** 数据权限操作管理 **/
    // 操作分组
    public static final String SUBGROUP = "subgroup";
    /** 声明角色管理模块常量 end **/
}

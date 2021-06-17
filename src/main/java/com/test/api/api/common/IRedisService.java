package com.test.api.api.common;

/**
 * @projectName api
 * @package com.test.api.api.common
 * @className IRedisService
 * @description redis缓存操作接口
 * @auther wangsheng
 * @creatTime 2021/6/18 12:58 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface IRedisService {
    /**
     * 存储数据
     * @param key 主键
     * @param value 值
     */
    void set(String key, String value);
}

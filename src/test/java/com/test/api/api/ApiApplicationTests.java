package com.test.api.api;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ApiApplicationTests {

    @Autowired
    private StringEncryptor jasyptStringEncryptor;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
    }

    /**
     * 加密
     */
    @Test
    public void encrypt() {
        System.out.println("encrypt: " + jasyptStringEncryptor.encrypt("helloser"));
    }

    /**
     * 解密
     */
    @Test
    public void decrypt() {
        System.out.println("decrypt: " + jasyptStringEncryptor.decrypt("o9uLVKcJV4C7SkdF9sZJzQ=="));
    }

    // string 入库
    @Test
    public void testForValue1() {
        String key = "zszxz";
        String value = "知识追寻者";
        redisTemplate.opsForValue().set(key, value);
    }

    // string 出库
    @Test
    public void testForValue2() {
        String key = "zszxz";
        Object value = redisTemplate.opsForValue().get(key);
        // 知识追寻者
        System.out.println(value);
    }

    // string key过期时间入库
    @Test
    public void testForValue3() {
        String key = "today";
        String value = "周六";
        long time = 60;
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    // 测试 key 是否存在
    @Test
    public void test11() {
        String key = "zszxz";
        Boolean exist = redisTemplate.hasKey(key);
        // true
        System.out.println(exist);
    }

    // 设置 key 过期时间
    @Test
    public void test22() {
        String key = "zszxz";
        long time = 5;
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }
    // 获取key过期时间
    @Test
    public void test33() {
        String key = "zszxz";
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        // 7
        System.out.println(expire);
    }
    // 删除key
    @Test
    public void test44() {
        String key = "zszxz22";
        boolean b = redisTemplate.delete(key);
        System.out.println(b);
    }

    // 放入一个 hash ( key value )
    @Test
    public void test15() {
        String key = "zszxz";
        String item = "name";
        String value = "知识追寻者";
        redisTemplate.opsForHash().put(key, item, value);
    }
    // 向hash中存放一个map
    @Test
    public void test26() {
        String key = "feature";
        Map<String, Object> map = new HashMap<>();
        map.put("name", "知识追寻者");
        map.put("age", "18");
        redisTemplate.opsForHash().putAll(key, map);
    }
    // 获取一个hash 的 所有key-value
    @Test
    public void test37() {
        String key = "feature";
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
        // {name=知识追寻者, age=18}
        System.out.println(entries);
    }
    // 获取一个hash 的 指定key 的value
    @Test
    public void test48() {
        String key = "feature";
        String item = "name";
        Object value = redisTemplate.opsForHash().get(key, item);
        // 知识追寻者
        System.out.println(value);
    }
    // 删除指定 hash key 的value
    @Test
    public void test59() {
        String key = "zszxz";
        String item = "name";
        redisTemplate.opsForHash().delete(key, item);
    }
    // 是否存在 指定 hash 的key
    @Test
    public void test610() {
        String key = "zszxz";
        String item = "name";
        Boolean exist = redisTemplate.opsForHash().hasKey(key, item);
        // false
        System.out.println(exist);
    }

    // 列表右推入
    @Test
    public void test111() {
        String key = "zszxz";
        String value = "知识追寻者";
        redisTemplate.opsForList().rightPush(key, value);
    }
    // 列表左推入
    @Test
    public void test212() {
        String key = "zszxz";
        String value = "晴雨天";
        redisTemplate.opsForList().leftPush(key, value);
    }

    // 列表左弹出
    @Test
    public void test313() {
        String key = "zszxz";
        Object value = redisTemplate.opsForList().leftPop(key);
        // 晴雨天
        System.out.println(value);
    }
    // 列表右弹出
    @Test
    public void test414() {
        String key = "zszxz";
        Object value = redisTemplate.opsForList().rightPop(key);
        // 知识追寻者
        System.out.println(value);
    }
    // 将list右推入列表
    @Test
    public void test515() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        String key = "number";
        redisTemplate.opsForList().rightPushAll(key, list);
    }
    // 修改列表指定索引的值
    @Test
    public void test716() {
        String key = "number";
        int index = 0;
        int value = 666;
        redisTemplate.opsForList().set(key, index, value);
    }
    // 获取列表指定索引的值
    @Test
    public void test817() {
        String key = "number";
        int index = 0;
        Object value = redisTemplate.opsForList().index(key, index);
        // 666
        System.out.println(value);
    }
    // set 中存储值
    @Test
    public void test118() {
        String key = "zszxz";
        String value1 = "晴雨天";
        String value2 = "公众号：知识追寻者";
        redisTemplate.opsForSet().add(key, value1, value2);
    }
    // 从 set 中取值
    @Test
    public void test219() {
        String key = "zszxz";
        Set<Object> members = redisTemplate.opsForSet().members(key);
        // [晴雨天, 公众号：知识追寻者]
        System.out.println(members);
    }
    // 判定 set 中是否存在 key-value
    @Test
    public void test320() {
        String key = "zszxz";
        String value = "晴雨天";
        Boolean member = redisTemplate.opsForSet().isMember(key, value);
        // true
        System.out.println(member);
    }
}

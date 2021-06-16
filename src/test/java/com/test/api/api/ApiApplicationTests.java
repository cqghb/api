package com.test.api.api;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

    @Autowired
    private StringEncryptor jasyptStringEncryptor;

    @Test
    void contextLoads() {
    }
    @Test
    public void encrypt() {
        System.out.println("encrypt: " + jasyptStringEncryptor.encrypt("nkfpmbygbjpubbeh"));
    }
    @Test
    public void decrypt() {
        System.out.println("decrypt: " + jasyptStringEncryptor.decrypt("o9uLVKcJV4C7SkdF9sZJzQ=="));
    }
}

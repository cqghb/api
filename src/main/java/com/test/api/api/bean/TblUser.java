package com.test.api.api.bean;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.bean
 * @className TblUser
 * @description 用户表实体类
 * @auther wangsheng
 * @creatTime 2020/11/6 12:33 上午
 * @company demo
 * @department demo
 */
public class TblUser extends BaseBean implements Serializable {

    private String id;
    private String name;
    private String pass;

    public TblUser() {
    }

    public TblUser(String id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "TblUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}

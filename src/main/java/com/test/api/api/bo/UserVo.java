package com.test.api.api.bo;

import com.test.api.api.bean.TblUser;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.bo
 * @className UserVo
 * @description
 * @auther wangsheng
 * @creatTime 2021/5/17 10:15 下午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class UserVo extends TblUser implements Serializable {
    // 喜好
    String[] likes;

    public UserVo() {
    }

    public UserVo(String createUser, Date createTime, String updateUser, Date updateTime, String id, String name, String pass, Integer age, String sex, Date birthday, String qq, String weChat, String email, String education, String[] likes) {
        super(createUser, createTime, updateUser, updateTime, id, name, pass, age, sex, birthday, qq, weChat, email, education);
        this.likes = likes;
    }

    public String[] getLikes() {
        return likes;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "likes=" + Arrays.toString(likes) +
                '}';
    }
}

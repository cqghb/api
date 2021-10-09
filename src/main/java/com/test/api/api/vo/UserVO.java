package com.test.api.api.vo;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblUser;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo
 * @className UserVO
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/8/11 1:29 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class UserVO extends TblUser implements Serializable {
    private static final long serialVersionUID = -6042139033862797564L;
    // 喜好
    List<String> likes;

    public UserVO() {
    }

    public UserVO(String createUser, Date createTime, String updateUser, Date updateTime, String id, String name,
                  String pass, Integer age, String sex, Date birthday, String qq, String weChat, String email,
                  String education, List<String> likes, String remark, String delTag) {
        super(createUser, createTime, updateUser, updateTime, id, name, pass, age, sex, birthday, qq, weChat, email,
                education, remark, delTag);
        this.likes = likes;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "UserVO{" + JSONObject.toJSONString(this) + '}';
    }
}

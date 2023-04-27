package com.test.api.api.vo;

import com.test.api.api.bean.TblUser;
import lombok.Data;

import java.io.Serializable;
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
@Data
public class UserVO extends TblUser implements Serializable {
    private static final long serialVersionUID = -6042139033862797564L;
    // 喜好
    List<String> likes;
}

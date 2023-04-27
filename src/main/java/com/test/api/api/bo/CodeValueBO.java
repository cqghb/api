package com.test.api.api.bo;

import com.test.api.api.bean.TblCodeValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.bo
 * @className CodeValueBO
 * @description 码值查询对象
 * @auther wangsheng
 * @creatTime 2021/8/24 1:20 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class CodeValueBO extends TblCodeValue implements Serializable {
    // 码值
    private List<String> codeList;
}

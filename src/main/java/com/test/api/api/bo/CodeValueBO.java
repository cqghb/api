package com.test.api.api.bo;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblCodeValue;

import java.io.Serializable;
import java.util.Date;
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
public class CodeValueBO extends TblCodeValue implements Serializable {
    // 码值
    private List<String> codeList;

    public CodeValueBO() {
    }

    public CodeValueBO(String createUser, Date createTime, String updateUser, Date updateTime, String codeType, String code, String codeName, Integer index, List<String> codeList) {
        super(createUser, createTime, updateUser, updateTime, codeType, code, codeName, index);
        this.codeList = codeList;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    @Override
    public String toString() {
        return "CodeValueBO{" + JSONObject.toJSONString(this) + "}";
    }
}

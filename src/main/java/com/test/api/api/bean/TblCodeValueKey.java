package com.test.api.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName api
 * @package com.test.api.api.bean
 * @className TblCodeValueKey
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/5/10 12:09 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class TblCodeValueKey extends BaseBean implements Serializable {

    /**
     * 码类型
     */
    private String codeType;

    /**
     * 码
     */
    private String code;

    /**
     * 中文
     */
    private String codeName;

    private static final long serialVersionUID = 1L;

    public TblCodeValueKey() {
    }

    public TblCodeValueKey(String createUser, Date createTime, String updateUser, Date updateTime, String codeType, String code, String codeName) {
        super(createUser, createTime, updateUser, updateTime);
        this.codeType = codeType;
        this.code = code;
        this.codeName = codeName;
    }
}

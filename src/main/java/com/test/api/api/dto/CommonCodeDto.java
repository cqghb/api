package com.test.api.api.dto;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto
 * @className CommonCodeDto
 * @description 根据Code参数删除数据的公共参数对象
 * @auther wangsheng
 * @creatTime 2021/10/7 12:10 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class CommonCodeDto implements Serializable {

    private static final long serialVersionUID = -2386674488054276130L;
    /**
     * 角色名称
     */
    @NotNull(message = "编码不能为空")
    @NotBlank(message = "编码不能为空")
    private String code;

    public CommonCodeDto() {
    }

    public CommonCodeDto(@NotNull(message = "编码不能为空") @NotBlank(message = "编码不能为空") String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DeleteDataDto{" + JSONObject.toJSONString(this) + "}";
    }
}

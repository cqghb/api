package com.test.api.api.dto.commodity.spubrand;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.spubrand
 * @className UpdateSpuBrandDto
 * @description 维护SPU品牌表单对象
 * @auther wangsheng
 * @creatTime 2022/4/23 下午4:56
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class UpdateSpuBrandDto extends AddSpuBrandDto implements Serializable {
    private static final long serialVersionUID = 8122275565816121190L;

    /**
     * 品牌ID
     */
    @NotNull(message = "品牌ID不能为空")
    @NotBlank(message = "品牌ID不能为空")
    private String id;

    public UpdateSpuBrandDto() {
    }

    public UpdateSpuBrandDto(String remark, String delTag, @NotNull(message = "品牌名称不能为空") @NotBlank(message =
            "品牌名称不能为空") String name, @NotNull(message = "品牌编码不能为空") @NotBlank(message = "品牌编码不能为空") String code,
                             @NotNull(message = "品牌ID不能为空") @NotBlank(message = "品牌ID不能为空") String id) {
        super(remark, delTag, name, code);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateSpuBrandDto{" + JSONObject.toJSONString(this) + "}";
    }
}

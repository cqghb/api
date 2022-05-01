package com.test.api.api.dto.commodity.spu;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.spu
 * @className UpdateSpuDto
 * @description 维护货品表单对象
 * @auther wangsheng
 * @creatTime 2022/5/1 下午11:53
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class UpdateSpuDto extends AddSpuDto implements Serializable {
    private static final long serialVersionUID = 6837693687865888413L;

    /**
     * 品牌ID
     */
    @NotNull(message = "品牌ID不能为空")
    @NotBlank(message = "品牌ID不能为空")
    private String id;

    public UpdateSpuDto() {
    }

    public UpdateSpuDto(String remark, String delTag,
                        @NotNull(message = "货品名称不能为空") @NotBlank(message = "货品名称不能为空") String name, @NotNull(message =
            "货品编码不能为空") @NotBlank(message = "货品编码不能为空") String code, String briefIntroduction, String detail,
                        @NotNull(message = "分类ID不能为空") @NotBlank(message = "分类ID不能为空") String typeId,
                        @NotNull(message = "品牌ID不能为空") @NotBlank(message = "品牌ID不能为空") String brandId,
                        @NotNull(message = "品牌ID不能为空") @NotBlank(message = "品牌ID不能为空") String id) {
        super(remark, delTag, name, code, briefIntroduction, detail, typeId, brandId);
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
        return "UpdateSpuDto{" + JSONObject.toJSONString(this) + "}";
    }
}

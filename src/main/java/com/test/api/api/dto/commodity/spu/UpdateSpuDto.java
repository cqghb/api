package com.test.api.api.dto.commodity.spu;

import lombok.Data;

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
@Data
public class UpdateSpuDto extends AddSpuDto implements Serializable {
    private static final long serialVersionUID = 6837693687865888413L;

    /**
     * 品牌ID
     */
    @NotNull(message = "品牌ID不能为空")
    @NotBlank(message = "品牌ID不能为空")
    private String id;
}

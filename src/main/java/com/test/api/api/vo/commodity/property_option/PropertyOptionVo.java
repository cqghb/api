package com.test.api.api.vo.commodity.property_option;

import com.test.api.api.bean.TblPropertyOptions;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.property_option
 * @className PropertyOptionVo
 * @description 产品属性值列表视图对象
 * @auther wangsheng
 * @creatTime 2022/1/18 上午12:20
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class PropertyOptionVo extends TblPropertyOptions implements Serializable {
    private static final long serialVersionUID = -6834760336236234799L;

    /**
     * 产品属性值对应的名称
     */
    private String propertyName;
}

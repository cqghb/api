package com.test.api.api.vo.commodity.skupropertyoption;

import com.test.api.api.bean.TblSkuPropertyOption;
import com.test.api.api.vo.commodity.property_option.PropertyOptionVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.skupropertyoption
 * @className SkuPropertyOptionVO
 * @description 产品属性详情视图对象
 * @auther wangsheng
 * @creatTime 2022/1/24 上午12:43
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class SkuPropertyOptionVO extends TblSkuPropertyOption implements Serializable {
    private static final long serialVersionUID = 4062152762940940741L;

    /**
     * 产品ID-产品名称
     */
    private String skuIdName;

    /**
     * 产品属性列表
     */
    private List<PropertyOptionVo> listProperty;

    /**
     * 属性值ID-属性值
     */
    private String proOptIdName;
}

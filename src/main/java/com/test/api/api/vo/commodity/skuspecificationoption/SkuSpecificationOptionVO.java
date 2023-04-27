package com.test.api.api.vo.commodity.skuspecificationoption;

import com.test.api.api.bean.BaseBean;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.skuspecificationoption
 * @className SkuSpecificationOptionVO
 * @description 产品规格选项配置试图对象
 * @auther wangsheng
 * @creatTime 2022/4/19 上午12:38
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class SkuSpecificationOptionVO extends BaseBean implements Serializable {
    private static final long serialVersionUID = 104113708598305786L;

    /**
     * 产品主键
     */
    private String skuId;
    /**
     * 产品代码
     */
    private String skuCode;
    /**
     * 产品名称
     */
    private String skuName;
    /**
     * 规格主键
     */
    private String id;
    /**
     * 规格名称
     */
    private String specName;
    /**
     * 规格选项ID
     */
    private String specOptiId;
    /**
     * 规格选项值
     */
    private String specOptiValue;

}

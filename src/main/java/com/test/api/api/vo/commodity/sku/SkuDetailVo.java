package com.test.api.api.vo.commodity.sku;

import com.test.api.api.bean.*;
import lombok.Data;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.sku
 * @className SkuDetailVo
 * @description 商品详细信息
 * @auther wangsheng
 * @creatTime 2023/5/4 上午12:54
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class SkuDetailVo extends TblSku {

    /**
     * 商品售后
     */
    private TblSkuAfterSales afterSales;
    /**
     * 商品基本属性
     */
    private List<TblProperty> propertyList;
    /**
     * 商品规格组
     */
    private List<TblSpecification> specificationList;
    /**
     * 商品影像
     */
    private List<TblImage> imageList;
}

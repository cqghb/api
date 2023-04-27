package com.test.api.api.vo.commodity.sku;

import com.test.api.api.bean.TblSku;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.sku
 * @className SkuMainVo
 * @description 产品列表也表单视图对象，显示比较重要的字段，比较全面
 * @auther wangsheng
 * @creatTime 2022/5/3 下午11:01
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class SkuMainVo extends TblSku implements Serializable {
    private static final long serialVersionUID = 5369861084550121322L;

    /**
     * 产品编码-名称
     */
    private String skuCodeName;
    /**
     * 货品编码
     */
    private String spuCode;
    /**
     * 货品名称
     */
    private String spuName;
    /**
     * 货品编码-名称
     */
    private String spuCodeName;
    /**
     * 品牌ID
     */
    private String brandId;
    /**
     * 品牌编码
     */
    private String brandCode;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 品牌编码-名称
     */
    private String brandCodeName;
    /**
     * 货品类型ID
     */
    private String spuTypeId;
    /**
     * 货品类型编码
     */
    private String spuTypeCode;
    /**
     * 货品类型名称
     */
    private String spuTypeName;
    /**
     * 货品类型编码-名称
     */
    private String spuTypeCodeName;
    /**
     * 产品规格ID
     */
    private String speId;
    /**
     * 产品规格名称
     */
    private String speName;
    /**
     * 产品规格ID-名称
     */
    private String speIdName;
}

package com.test.api.api.vo.commodity.property;

import com.test.api.api.bean.TblProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.property
 * @className PropertyVo
 * @description 产品属性详细信息
 * @auther wangsheng
 * @creatTime 2022/1/13 上午1:37
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class PropertyVo extends TblProperty implements Serializable {
    private static final long serialVersionUID = -8347152780339279502L;
    /* 货品类型名称 */
    private String typeIdName;
}

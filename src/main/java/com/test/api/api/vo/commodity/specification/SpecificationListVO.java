package com.test.api.api.vo.commodity.specification;

import com.test.api.api.bean.TblSpecification;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity
 * @className SpecificationVO
 * @description 产品规格管理列表视图对象
 * @auther wangsheng
 * @creatTime 2022/1/5 上午1:33
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class SpecificationListVO extends TblSpecification implements Serializable {

    private static final long serialVersionUID = -673810591275147981L;
    /**
     * 规格组ID-名称
     */
    private String groupIdName;

    /**
     * 分类ID-名称
     */
    private String typeIdName;
}

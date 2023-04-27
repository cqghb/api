package com.test.api.api.vo.commodity.spu;

import com.test.api.api.bean.TblSpu;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.vo.commodity.spu
 * @className ListSpuVO
 * @description 货品管理-货品列表展示对象
 * @auther wangsheng
 * @creatTime 2022/4/27 上午12:43
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class ListSpuVO extends TblSpu implements Serializable {
    private static final long serialVersionUID = -5788405881059158828L;

    /**
     * 货品所属类型
     */
    private String typeName;
    /**
     * 货品所属品牌
     */
    private String brandName;
}

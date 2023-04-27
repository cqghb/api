package com.test.api.api.dto.menumanager;

import com.test.api.api.bean.TblMenu;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.menumanager
 * @className QueryParentMenuParamsDto
 * @description 查询父节点的查询条件
 * @auther wangsheng
 * @creatTime 2021/9/24 1:19 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class QueryParentMenuParamsDto extends TblMenu implements Serializable {
    /**
     * 本节点ID
     */
    private String theId;
}

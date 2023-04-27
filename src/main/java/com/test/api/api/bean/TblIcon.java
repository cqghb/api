package com.test.api.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.bean
 * @className TblIcon
 * @description 图标表实体
 * @auther wangsheng
 * @creatTime 2021/9/8 12:47 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class TblIcon extends BaseBean implements Serializable {
    private static final long serialVersionUID = 3417282613065084242L;

    // 主键
    private String id;
    // 图标中文名称
    private String name;
    // 图标英文名称
    private String englishName;
    // 排序
    private int index;
}

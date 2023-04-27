package com.test.api.api.dto.rolemanager;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.rolemanager
 * @className TblDataOperateInsertDto
 * @description 数据操作表单对象
 * @auther wangsheng
 * @creatTime 2021/10/9 1:16 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Data
public class TblDataOperateInsertDto implements Serializable {

    private static final long serialVersionUID = 3343610222187425126L;

    /**
     * 主键
     */
    private String id;

    /**
     * 操作名称
     */
    @NotNull(message = "操作名称不能为空")
    @NotBlank(message = "操作名称不能为空")
    private String name;

    /**
     * 操作地址[地址要写全]
     */
    /**
     * 操作名称
     */
    @NotNull(message = "操作地址不能为空")
    @NotBlank(message = "操作地址不能为空")
    private String operateAddr;

    /**
     * 备注
     */
    private String remark;

    /**
     * 所属分组
     */
    @NotNull(message = "所属分组不能为空")
    @NotBlank(message = "所属分组不能为空")
    private String subgroup;

}

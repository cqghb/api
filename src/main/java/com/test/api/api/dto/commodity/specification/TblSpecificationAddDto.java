package com.test.api.api.dto.commodity.specification;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.dto.BaseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.commodity.specification
 * @className TblSpecificationAddDto
 * @description 添加货品规格表单对象
 * @auther wangsheng
 * @creatTime 2022/1/4 下午1:07
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class TblSpecificationAddDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -4940024653454849778L;

    /**
     * 规格ID
     */
    private String id;

    /**
     * 参数名称
     */
    @NotNull(message = "产品规格名称不能为空")
    @NotBlank(message = "产品规格名称不能为空")
    private String name;

    /**
     * 规格组ID
     */
    @NotNull(message = "产品规格规格组ID不能为空")
    @NotBlank(message = "产品规格规格组ID不能为空")
    private String groupId;

    /**
     * 分类ID
     */
    @NotNull(message = "产品规格分类ID不能为空")
    @NotBlank(message = "产品规格分类ID不能为空")
    private String typeId;

    /**
     * 显示位置
     */
    private String addr;

    public TblSpecificationAddDto() {
    }

    public TblSpecificationAddDto(String remark, String delTag, String id,
                                  @NotNull(message = "产品规格名称不能为空") @NotBlank(message = "产品规格名称不能为空") String name,
                                  @NotNull(message = "产品规格规格组ID不能为空") @NotBlank(message = "产品规格规格组ID不能为空") String groupId, @NotNull(message = "产品规格分类ID不能为空") @NotBlank(message = "产品规格分类ID不能为空") String typeId, String addr) {
        super(remark, delTag);
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.typeId = typeId;
        this.addr = addr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "TblSpecificationAddDto{" + JSONObject.toJSONString(this) + "}";
    }
}
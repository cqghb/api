package com.test.api.api.dto.rolemanager;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.rolemanager
 * @className TblDataOperateDto
 * @description 数据操作表单对象
 * @auther wangsheng
 * @creatTime 2021/10/9 1:16 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class TblDataOperateDto implements Serializable {

    private static final long serialVersionUID = 3343610222187425126L;

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空")
    @NotBlank(message = "主键不能为空")
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

    public TblDataOperateDto(@NotNull(message = "主键不能为空") @NotBlank(message = "主键不能为空") String id, @NotNull(message =
            "操作名称不能为空") @NotBlank(message = "操作名称不能为空") String name,
                             @NotNull(message = "操作地址不能为空") @NotBlank(message = "操作地址不能为空") String operateAddr) {
        this.id = id;
        this.name = name;
        this.operateAddr = operateAddr;
    }

    public TblDataOperateDto() {
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

    public String getOperateAddr() {
        return operateAddr;
    }

    public void setOperateAddr(String operateAddr) {
        this.operateAddr = operateAddr;
    }

    @Override
    public String toString() {
        return "TblDataOperateDto{" + JSONObject.toJSONString(this) + "}";
    }
}

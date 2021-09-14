package com.test.api.api.dto.menumanager;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @projectName api
 * @package com.test.api.api.dto.menumanager
 * @className TblMenuDelDto
 * @description 删除菜单参数
 * @auther wangsheng
 * @creatTime 2021/9/14 12:53 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public class TblMenuDelDto implements Serializable {
    private static final long serialVersionUID = -8751835891322753595L;

    @NotBlank(message = "ID不能为空")
    private String id;

    public TblMenuDelDto() {
    }

    public TblMenuDelDto(@NotBlank(message = "ID不能为空") String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TblMenuDelDto{" + JSONObject.toJSONString(this) + "}";
    }
}

package com.test.api.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

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

    public TblIcon() {
    }

    public TblIcon(String createUser, Date createTime, String updateUser, Date updateTime, String id, String name,
                   String englishName, int index, String remark, String delTag) {
        super(createUser, createTime, updateUser, updateTime, remark, delTag);
        this.id = id;
        this.name = name;
        this.englishName = englishName;
        this.index = index;
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

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "TblIcon{" + JSONObject.toJSONString(this) + "}";
    }
}

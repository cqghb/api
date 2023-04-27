package com.test.api.api.vo;

import com.test.api.api.bean.TblMenu;
import lombok.Data;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.vo
 * @className MenuTree
 * @description 菜单树
 * @auther wangsheng
 * @creatTime 2020/11/7 7:54 下午
 * @company demo
 * @department demo
 */
@Data
public class MenuTree implements java.io.Serializable {

    // 默认选中的菜单
    List<String> defaultSelectList;
    // 子菜单
    List<TblMenu> rootTree;
}

package com.test.api.api.dao;

import com.test.api.api.bean.TblMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.dao
 * @className TblMenuDao
 * @description TODO
 * @auther wangsheng
 * @creatTime 2020/11/7 7:32 下午
 * @company demo
 * @department demo
 */
@Repository
public interface TblMenuDao {
    /**
     * 菜单查询
     * @param params 查询条件
     * @return
     */
    List<TblMenu> queryList(TblMenu params);

    /**
     * 查询默认选中的菜单
     * @return
     */
    List<String> queryDefaultSelect();

}

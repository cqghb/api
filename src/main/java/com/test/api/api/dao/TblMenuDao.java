package com.test.api.api.dao;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblMenu;
import org.apache.ibatis.annotations.Param;
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
    List<TblMenu> queryList(JSONObject params);

    /**
     * 查询默认选中的菜单
     * @return
     */
    List<String> queryDefaultSelect();

    /**
     * 新增
     * @param menu
     * @return
     */
    int insertSelective(TblMenu menu);

    /**
     * 通过ID删除菜单
     * @param id 主键
     * @return
     */
    int deleteById(@Param("id") String id);


    TblMenu selectByPKDelTag(@Param("id") String id, @Param("delTag") String delTag);

    TblMenu selectByPrimaryKey(@Param("id") String id);

    /**
     * 查询所有父菜单
     * @param params 查询条件
     * @return
     */
    List<TblMenu> queryPageParentMenu(JSONObject params);

    int updateByPrimaryKeySelective(TblMenu params);

    /**
     * 根据用户编号查询用户菜单
     * @param userNo 用户编号
     * @return
     */
    List<TblMenu> queryUserMenu(@Param("userNo") String userNo);
    /**
     * 修改菜单删除标志
     * @param params 菜单对象
     * @return
     */
    int updateMenuDelTag(TblMenu params);
}

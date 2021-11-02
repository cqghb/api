package com.test.api.api.service;

import com.test.api.api.bean.TblRole;
import com.test.api.api.config.AppException;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblRoleService
 * @description 角色服务接口
 * @auther wangsheng
 * @creatTime 2021/9/29 2:06 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblRoleService {

    int deleteByPrimaryKey(String id);

    int insert(TblRole record);

    int insertSelective(TblRole record);

    TblRole selectByPrimaryKey(String id, String delTag);

    int updateByPrimaryKeySelective(TblRole record) throws AppException;

    int updateByPrimaryKey(TblRole record);

    /**
     * 分页查询
     * @param pageRequest 分页参数
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 修改角色删除标志
     * @param record 角色对象
     * @return
     */
    int updateRoleDelTag(TblRole record) throws AppException;

    /**
     * 查询所有角色
     * @return
     */
    List<TblRole> queryAllRole();
}

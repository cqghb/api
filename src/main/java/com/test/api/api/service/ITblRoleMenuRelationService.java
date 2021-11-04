package com.test.api.api.service;

import com.test.api.api.bean.TblRoleMenuRelation;
import com.test.api.api.dto.rolemenurelation.RoleMenuRelationSettingDto;
import com.test.api.api.vo.rolemenurelation.RoleMenuRelationVO;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblRoleMenuRelationService
 * @description 角色菜单关系服务接口
 * @auther wangsheng
 * @creatTime 2021/9/29 2:08 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblRoleMenuRelationService {

    int deleteByPrimaryKey(String id);

    int insert(TblRoleMenuRelation record);

    int insertSelective(TblRoleMenuRelation record);

    TblRoleMenuRelation selectByPrimaryKey(String id, String delTag);

    int updateByPrimaryKeySelective(TblRoleMenuRelation record);

    int updateByPrimaryKey(TblRoleMenuRelation record);

    /**
     * 维护角色菜单权限
     * @param dto
     * @return
     */
    int updateRoleMenuRelation(RoleMenuRelationSettingDto dto);

    /**
     * 根据角色主键查询所有角色菜单
     * @param roleId 角色主键
     * @return
     */
    List<RoleMenuRelationVO> queryRoleMenu(String roleId);
}

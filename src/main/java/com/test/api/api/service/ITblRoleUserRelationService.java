package com.test.api.api.service;

import com.test.api.api.bean.TblRole;
import com.test.api.api.bean.TblRoleUserRelation;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblRoleUserRelationService
 * @description 用户角色关系服务接口
 * @auther wangsheng
 * @creatTime 2021/9/29 2:10 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblRoleUserRelationService {

    int deleteByPrimaryKey(String id);

    int insert(TblRoleUserRelation record);

    int insertSelective(TblRoleUserRelation record);

    TblRoleUserRelation selectByPrimaryKey(String id, String delTag);

    int updateByPrimaryKeySelective(TblRoleUserRelation record);

    int updateByPrimaryKey(TblRoleUserRelation record);

    /**
     * 查询用户角色列表
     *
     * @param userId 用户主键
     * @param delTag 删除标记
     * @return
     */
    List<TblRole> queryUserRoleByUserId(String userId, String delTag);
}

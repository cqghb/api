package com.test.api.api.service.impl;

import com.test.api.api.bean.TblRole;
import com.test.api.api.bean.TblRoleUserRelation;
import com.test.api.api.bean.TblUser;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblRoleUserRelationDao;
import com.test.api.api.dto.roleuserrelation.UserRoleRelationSettingDto;
import com.test.api.api.service.ITblRoleService;
import com.test.api.api.service.ITblRoleUserRelationService;
import com.test.api.api.service.ITblUserService;
import com.test.api.api.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblRoleUserRelationService
 * @description 用户角色关系服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/29 2:10 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblRoleUserRelationService extends CommonService implements ITblRoleUserRelationService {

    @Autowired
    private TblRoleUserRelationDao roleUserRelationDao;

    @Autowired
    private ITblUserService userService;

    @Autowired
    private ITblRoleService roleService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return roleUserRelationDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblRoleUserRelation record) {
        return roleUserRelationDao.insert(record);
    }

    @Override
    public int insertSelective(TblRoleUserRelation record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return roleUserRelationDao.insertSelective(record);
    }

    @Override
    public TblRoleUserRelation selectByPrimaryKey(String id, String delTag) {
        return roleUserRelationDao.selectByPrimaryKey(id, delTag);
    }

    @Override
    public int updateByPrimaryKeySelective(TblRoleUserRelation record) {
        return roleUserRelationDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TblRoleUserRelation record) {
        return roleUserRelationDao.updateByPrimaryKey(record);
    }

    @Override
    public List<TblRole> queryUserRoleByUserId(String userId, String delTag) {
        return roleUserRelationDao.queryUserRoleByUserId(userId, delTag);
    }

    @Override
    public int updateUserRoleRelation(UserRoleRelationSettingDto dto) throws AppException {
        /**
         * 1. 检查用户和角色是否都还存在，不存在报错抛出去
         * 2. 清理掉原来的关系
         * 3. 设置新的关系
         */
        // 1. 检查用户和角色是否都还存在，不存在报错抛出去
        String userId = dto.getUserId();
        TblUser user = userService.selectByPKDelTag(userId, DelTagEnum.DEL_TAG_2.getCode());
        if(StringUtil.objIsEmpty(user)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.USERID_ROLEID_RELATION_ERROR_1);
        }
        for(String roleId : dto.getRoleIdList()){
            TblRole role = roleService.selectByPKDelTag(roleId, DelTagEnum.DEL_TAG_2.getCode());
            if(StringUtil.objIsEmpty(role)){
                throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.ROLEID_ERROR_2);
            }
        }
        // 2. 清理掉原来的关系
        TblRoleUserRelation userRoleRelation = new TblRoleUserRelation();
        setObjectUpdateInfo(userRoleRelation, null);
        userRoleRelation.setUserId(userId);
        userRoleRelation.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        roleUserRelationDao.deleteByUserId(userRoleRelation);

        // 3. 设置新的关系
        int updateNum = 0;
        for(String roleId : dto.getRoleIdList()){
            TblRoleUserRelation relation = new TblRoleUserRelation();
            relation.setUserId(userId);
            relation.setRoleId(roleId);
            this.insertSelective(relation);
            updateNum++;
        }
        return updateNum;
    }
}

package com.test.api.api.service.impl;

import com.test.api.api.bean.TblMenu;
import com.test.api.api.bean.TblRole;
import com.test.api.api.bean.TblRoleMenuRelation;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblRoleMenuRelationDao;
import com.test.api.api.dto.rolemenurelation.RoleMenuRelationSettingDto;
import com.test.api.api.service.ITblMenuService;
import com.test.api.api.service.ITblRoleMenuRelationService;
import com.test.api.api.service.ITblRoleService;
import com.test.api.api.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblRoleMenuRelationService
 * @description 角色菜单关系服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/29 2:08 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblRoleMenuRelationService extends CommonService implements ITblRoleMenuRelationService {

    @Autowired
    private TblRoleMenuRelationDao roleMenuRelationDao;

    @Autowired
    private ITblRoleService roleService;

    @Autowired
    private ITblMenuService menuService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return roleMenuRelationDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblRoleMenuRelation record) {
        return roleMenuRelationDao.insert(record);
    }

    @Override
    public int insertSelective(TblRoleMenuRelation record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return roleMenuRelationDao.insertSelective(record);
    }

    @Override
    public TblRoleMenuRelation selectByPrimaryKey(String id, String delTag) {
        return roleMenuRelationDao.selectByPrimaryKey(id, delTag);
    }

    @Override
    public int updateByPrimaryKeySelective(TblRoleMenuRelation record) {
        return roleMenuRelationDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TblRoleMenuRelation record) {
        return roleMenuRelationDao.updateByPrimaryKey(record);
    }

    @Override
    public int updateRoleMenuRelation(RoleMenuRelationSettingDto dto) {
        /**
         * 1. 检查角色和菜单是否都还存在，不存在报错抛出去
         * 2. 清理掉原来的关系
         * 3. 设置新的关系
         */
        String roleId = dto.getRoleId();
        // 1. 检查角色和菜单是否都还存在，不存在报错抛出去
        TblRole role = roleService.selectByPrimaryKey(roleId, DelTagEnum.DEL_TAG_2.getCode());
        if(StringUtil.objIsEmpty(role)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.ROLEID_ERROR_2);
        }
        for(String item : dto.getMenuIdList()){
            TblMenu menu = menuService.selectByPrimaryKey(item, DelTagEnum.DEL_TAG_2.getCode());
            if(StringUtil.objIsEmpty(menu)){
                throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.MENU_DATA_OPERATE_RELATIO_ERROR_2);
            }
        }

        // 2. 清理掉原来的关系
        TblRoleMenuRelation roleMenuRelation = new TblRoleMenuRelation();
        setObjectUpdateInfo(roleMenuRelation, null);
        roleMenuRelation.setRoleId(roleId);
        roleMenuRelation.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        roleMenuRelationDao.deleteByRoleId(roleMenuRelation);

        // 设置新的关系
        int updateNum = 0;
        for(String item : dto.getMenuIdList()){
            TblRoleMenuRelation newRoleMenuRelation = new TblRoleMenuRelation();
            newRoleMenuRelation.setMenuId(item);
            newRoleMenuRelation.setRoleId(roleId);
            this.insertSelective(newRoleMenuRelation);
            updateNum++;
        }
        return updateNum;
    }
}

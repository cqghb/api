package com.test.api.api.service.impl;

import com.test.api.api.bean.TblDataOperate;
import com.test.api.api.bean.TblMenu;
import com.test.api.api.bean.TblMenuDataOperateRelation;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblMenuDataOperateRelationDao;
import com.test.api.api.dto.menudataoperaterelationmanager.MenuDataOperateRelationSettingDto;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblDataOperateService;
import com.test.api.api.service.ITblMenuDataOperateRelationService;
import com.test.api.api.service.ITblMenuService;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.CodeValueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblMenuDataOperateRelationService
 * @description 菜单数据操作权限关系服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/29 2:05 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblMenuDataOperateRelationService implements ITblMenuDataOperateRelationService {

    @Autowired
    private TblMenuDataOperateRelationDao menuDataOperateRelationDao;

    @Autowired
    private ITblDataOperateService dataOperateService;

    @Autowired
    private ITblMenuService menuService;
    @Autowired
    private ICommonService iCommonService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return menuDataOperateRelationDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblMenuDataOperateRelation record) {
        return menuDataOperateRelationDao.insert(record);
    }

    @Override
    public int insertSelective(TblMenuDataOperateRelation record) {
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
        return menuDataOperateRelationDao.insertSelective(record);
    }

    @Override
    public TblMenuDataOperateRelation selectByPrimaryKey(String id, String delTag) {
        return menuDataOperateRelationDao.selectByPrimaryKey(id, delTag);
    }

    @Override
    public int updateByPrimaryKeySelective(TblMenuDataOperateRelation record) {
        TblMenuDataOperateRelation oldMenuDataOperateRelation = iCommonService.getInfo(menuDataOperateRelationDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, oldMenuDataOperateRelation);
        iCommonService.setObjectUpdateInfo(oldMenuDataOperateRelation, null);
        return menuDataOperateRelationDao.updateByPrimaryKeySelective(oldMenuDataOperateRelation);
    }

    @Override
    public int updateByPrimaryKey(TblMenuDataOperateRelation record) {
        return menuDataOperateRelationDao.updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    public int updateMenuDataOperateRelation(MenuDataOperateRelationSettingDto dto) {
        String menuId = dto.getMenuId();
        /**
         * 1. 检查菜单和数据操作是否都还存在，不存在报错抛出去
         * 2. 清理掉原来的关系
         * 3. 设置新的关系
         */
        // 1. 检查菜单和数据操作是否都还存在，不存在报错抛出去
        TblMenu menu = menuService.selectByPKDelTag(menuId, DelTagEnum.DEL_TAG_2.getCode());
        if(StringUtil.objIsEmpty(menu)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.MENU_DATA_OPERATE_RELATIO_ERROR_1);
        }
        for(String item : dto.getDataOperateList()){
            TblDataOperate dataOperate = dataOperateService.selectByPKDelTag(item, DelTagEnum.DEL_TAG_2.getCode());
            if(StringUtil.objIsEmpty(dataOperate)){
                throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.MENU_DATA_OPERATE_RELATIO_ERROR_2);
            }
        }
        // 2. 清理掉原来的关系
        TblMenuDataOperateRelation dataOperateRelation = new TblMenuDataOperateRelation();
        iCommonService.setObjectUpdateInfo(dataOperateRelation, null);
        dataOperateRelation.setMenuId(menuId);
        dataOperateRelation.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        menuDataOperateRelationDao.deleteByMenuId(dataOperateRelation);
        // 3. 设置新的关系
        int updateNum = 0;
        for(String item : dto.getDataOperateList()){
            TblMenuDataOperateRelation newMenuDataOperateRelation = new TblMenuDataOperateRelation();
            newMenuDataOperateRelation.setMenuId(menuId);
            newMenuDataOperateRelation.setDataOperId(item);
            this.insertSelective(newMenuDataOperateRelation);
            updateNum ++;
        }
        return updateNum;
    }

    @Override
    public List<CodeValueVO> queryMenuDataOperation(String menuId) {
        List<CodeValueVO> dataOperateGroupList = menuDataOperateRelationDao.queryMenuDataOperationGroup(menuId);
        return dataOperateGroupList;
    }
}

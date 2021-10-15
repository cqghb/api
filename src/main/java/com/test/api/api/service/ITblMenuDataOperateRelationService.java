package com.test.api.api.service;

import com.test.api.api.bean.TblMenuDataOperateRelation;
import com.test.api.api.dto.menudataoperaterelationmanager.MenuDataOperateRelationSettingDto;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblMenuDataOperateRelationService
 * @description 菜单数据操作权限关系服务接口
 * @auther wangsheng
 * @creatTime 2021/9/29 2:04 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblMenuDataOperateRelationService {

    int deleteByPrimaryKey(String id);

    int insert(TblMenuDataOperateRelation record);

    int insertSelective(TblMenuDataOperateRelation record);

    TblMenuDataOperateRelation selectByPrimaryKey(String id, String delTag);

    int updateByPrimaryKeySelective(TblMenuDataOperateRelation record);

    int updateByPrimaryKey(TblMenuDataOperateRelation record);

    /**
     * 维护菜单数据操作权限
     * @param dto
     * @return
     */
    int updateMenuDataOperateRelation(MenuDataOperateRelationSettingDto dto);
}

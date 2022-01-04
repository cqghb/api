package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSpecificationGroup;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpecificationGroupDao;
import com.test.api.api.service.ITblSpecificationGroupService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblSpecificationGroupService
 * @description 产品规格分组服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/30 上午12:38
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSpecificationGroupService extends CommonService implements ITblSpecificationGroupService {

    @Autowired
    private TblSpecificationGroupDao specificationGroupDao;


    @Override
    public int deleteByPrimaryKey(String id) {
        return specificationGroupDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSpecificationGroup record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return specificationGroupDao.insert(record);
    }

    @Override
    public int insertSelective(TblSpecificationGroup record) {
        /* 分组名称不能重复 */
        this.checkSGName(record.getName());
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return specificationGroupDao.insertSelective(record);
    }

    @Override
    public TblSpecificationGroup selectByPrimaryKey(String id) {
        return specificationGroupDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpecificationGroup record) {
        this.checkSGName(record.getName());
        TblSpecificationGroup specificationGroup = getInfo(specificationGroupDao, CommConstant.SELECT_BY_PRIMARY_KEY,
                record.getId());
        BeanUtils.copyProperties(record, specificationGroup);
        setObjectUpdateInfo(specificationGroup, null);
        return specificationGroupDao.updateByPrimaryKeySelective(specificationGroup);
    }

    @Override
    public int updateByPrimaryKey(TblSpecificationGroup record) {
        TblSpecificationGroup specificationGroup = getInfo(specificationGroupDao, CommConstant.SELECT_BY_PRIMARY_KEY,
                record.getId());
        BeanUtils.copyProperties(record, specificationGroup);
        setObjectUpdateInfo(specificationGroup, null);
        return specificationGroupDao.updateByPrimaryKey(specificationGroup);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(specificationGroupDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpecificationGroup record) {
        getInfo(specificationGroupDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return specificationGroupDao.updateDelTag(record);
    }

    @Override
    public void checkSGName(String name) {
        List<TblSpecificationGroup> list = specificationGroupDao.queryByName(name, DelTagEnum.DEL_TAG_2.getCode());
        if(!StringUtil.objIsEmpty(list)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPECIFICATION_GROUP_NAME_ERROR);
        }
    }

    @Override
    public TblSpecificationGroup checkSpecificationGroup(String id) {
        TblSpecificationGroup specificationGroup = this.selectByPrimaryKey(id);
        if (StringUtil.objIsEmpty(specificationGroup)) {
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPECIFICATION_GROUP_NOT_FIND);
        }
        return specificationGroup;
    }

    @Override
    public void checkDelTag(String id) {
        TblSpecificationGroup specificationGroup = this.checkSpecificationGroup(id);
        if (!DelTagEnum.DEL_TAG_2.getCode().equals(specificationGroup.getDelTag())) {
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPECIFICATION_GROUP_INVALID);
        }
    }


}

package com.test.api.api.service.impl;

import com.test.api.api.bean.TblProperty;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblPropertyDao;
import com.test.api.api.service.ITblPropertyService;
import com.test.api.api.service.ITblSpuTypeService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.commodity.property.PropertyVo;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblPropertyService
 * @description 产品属性服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/20 上午12:50
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblPropertyService extends CommonService implements ITblPropertyService {

    protected static final Logger logger = LoggerFactory.getLogger(TblPropertyService.class);

    @Autowired
    private TblPropertyDao propertyDao;
    @Autowired
    private ITblSpuTypeService spuTypeService;


    @Override
    public int deleteByPrimaryKey(String id) {
        return propertyDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblProperty record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return propertyDao.insert(record);
    }

    @Override
    public int insertSelective(TblProperty record) {
        /* 检查货品类型是否有效 */
        spuTypeService.checkDelTag(record.getTypeId());
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return propertyDao.insertSelective(record);
    }

    @Override
    public TblProperty selectByPrimaryKey(String id) {
        return propertyDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblProperty record) {
        /* 检查货品类型是否有效 */
        spuTypeService.checkDelTag(record.getTypeId());
        TblProperty property = getInfo(propertyDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, property);
        setObjectUpdateInfo(property, null);
        return propertyDao.updateByPrimaryKeySelective(property);
    }

    @Override
    public int updateByPrimaryKey(TblProperty record) {
        TblProperty property = getInfo(propertyDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, property);
        setObjectUpdateInfo(property, null);
        return propertyDao.updateByPrimaryKey(property);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(propertyDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblProperty record) {
        getInfo(propertyDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return propertyDao.updateDelTag(record);
    }

    @Override
    public PropertyVo queryDetail(String id) {
        if(StringUtil.objIsEmpty(id)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.ID_IS_NOT_NULL);
        }
        return propertyDao.queryDetail(id);
    }

    @Override
    public TblProperty checkProperty(String id) {
        if (!StringUtil.objIsEmpty(id)) {
            TblProperty property = this.selectByPrimaryKey(id);
            if (StringUtil.objIsEmpty(property)) {
                throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_PROPERTY_NOT_FIND);
            }
            return property;
        }
        return null;
    }

    @Override
    public void checkDelTag(String id) {
        if (!StringUtil.objIsEmpty(id)) {
            TblProperty property = this.checkProperty(id);
            if (!DelTagEnum.DEL_TAG_2.getCode().equals(property.getDelTag())) {
                throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_PROPERTY_INVALID);
            }
        }
    }
}

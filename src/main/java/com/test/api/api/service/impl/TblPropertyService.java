package com.test.api.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.api.api.bean.TblProperty;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblPropertyExtendsDao;
import com.test.api.api.service.ICommonService;
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
public class TblPropertyService extends ServiceImpl<TblPropertyExtendsDao, TblProperty> implements ITblPropertyService {

    protected static final Logger logger = LoggerFactory.getLogger(TblPropertyService.class);

    @Autowired
    private TblPropertyExtendsDao tblPropertyExtendsDao;

    @Autowired
    private ITblSpuTypeService spuTypeService;
    @Autowired
    private ICommonService iCommonService;


    @Override
    public int deleteByPrimaryKey(String id) {
        return tblPropertyExtendsDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblProperty record) {
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
//        tblPropertyExtendsDao.insert(record);
        return 1;
    }

    @Override
    public int insertSelective(TblProperty record) {
        /* 检查货品类型是否有效 */
//        spuTypeService.checkDelTag(record.getTypeId());
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
        return tblPropertyExtendsDao.insertSelective(record);
    }

    @Override
    public TblProperty selectByPrimaryKey(String id) {
        return tblPropertyExtendsDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblProperty record) {
        /* 检查货品类型是否有效 */
//        spuTypeService.checkDelTag(record.getTypeId());
        TblProperty property = iCommonService.getInfo(tblPropertyExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, property);
        iCommonService.setObjectUpdateInfo(property, null);
        return tblPropertyExtendsDao.updateByPrimaryKeySelective(property);
    }

    @Override
    public int updateByPrimaryKey(TblProperty record) {
        TblProperty property = iCommonService.getInfo(tblPropertyExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, property);
        iCommonService.setObjectUpdateInfo(property, null);
        return tblPropertyExtendsDao.updateByPrimaryKey(property);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(iCommonService.getPageInfo(tblPropertyExtendsDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblProperty record) {
        iCommonService.getInfo(tblPropertyExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        iCommonService.setObjectUpdateInfo(record, null);
//        return tblPropertyExtendsDao.updateDelTag(record);
        return 0;
    }

    @Override
    public PropertyVo queryDetail(String id) {
        if(StringUtil.objIsEmpty(id)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.ID_IS_NOT_NULL);
        }
//        return tblPropertyExtendsDao.queryDetail(id);
        return null;
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

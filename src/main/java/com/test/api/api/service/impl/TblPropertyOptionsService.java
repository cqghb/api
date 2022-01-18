package com.test.api.api.service.impl;

import com.test.api.api.bean.TblPropertyOptions;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblPropertyOptionsDao;
import com.test.api.api.service.ITblPropertyOptionsService;
import com.test.api.api.service.ITblPropertyService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.commodity.property_option.PropertyOptionVo;
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
 * @className TblPropertyOptionsService
 * @description 产品属性选项服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/20 上午12:49
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblPropertyOptionsService extends CommonService implements ITblPropertyOptionsService {

    protected static final Logger logger = LoggerFactory.getLogger(TblPropertyOptionsService.class);

    @Autowired
    private TblPropertyOptionsDao propertyOptionsDao;

    @Autowired
    private ITblPropertyService propertyService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return propertyOptionsDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblPropertyOptions record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return propertyOptionsDao.insert(record);
    }

    @Override
    public int insertSelective(TblPropertyOptions record) {
        /* 检查产品属性是否正常 */
        propertyService.checkDelTag(record.getAttrId());
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return propertyOptionsDao.insertSelective(record);
    }

    @Override
    public TblPropertyOptions selectByPrimaryKey(String id) {
        return propertyOptionsDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblPropertyOptions record) {
        /* 检查产品属性是否正常 */
        propertyService.checkDelTag(record.getAttrId());
        TblPropertyOptions propertyOptions = getInfo(propertyOptionsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, propertyOptions);
        setObjectUpdateInfo(propertyOptions, null);
        return propertyOptionsDao.updateByPrimaryKeySelective(propertyOptions);
    }

    @Override
    public int updateByPrimaryKey(TblPropertyOptions record) {
        TblPropertyOptions propertyOptions = getInfo(propertyOptionsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, propertyOptions);
        setObjectUpdateInfo(propertyOptions, null);
        return propertyOptionsDao.updateByPrimaryKey(propertyOptions);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(propertyOptionsDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblPropertyOptions record) {
        getInfo(propertyOptionsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return propertyOptionsDao.updateDelTag(record);
    }

    @Override
    public PropertyOptionVo queryDetail(String id) {
        return propertyOptionsDao.queryDetail(id);
    }

    @Override
    public TblPropertyOptions checkPropertyOption(String id) {
        if (!StringUtil.objIsEmpty(id)) {
            TblPropertyOptions propertyOptions = this.selectByPrimaryKey(id);
            if (StringUtil.objIsEmpty(propertyOptions)) {
                throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_PROPERTY_OPTION_NOT_FIND);
            }
            return propertyOptions;
        }
        return null;
    }

    @Override
    public void checkDelTag(String id) {
        if (!StringUtil.objIsEmpty(id)) {
            TblPropertyOptions propertyOptions = this.checkPropertyOption(id);
            if (!DelTagEnum.DEL_TAG_2.getCode().equals(propertyOptions.getDelTag())) {
                throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_PROPERTY_OPTION_INVALID);
            }
        }
    }
}

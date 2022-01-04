package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSpuType;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpuTypeDao;
import com.test.api.api.service.ITblSpuTypeService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
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
 * @className TblSpuTypeService
 * @description 货品类型服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/15 下午11:17
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSpuTypeService extends CommonService implements ITblSpuTypeService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSpuTypeService.class);

    @Autowired
    private TblSpuTypeDao spuTypeDao;


    @Override
    public int deleteByPrimaryKey(String id) {
        return spuTypeDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSpuType record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return spuTypeDao.insert(record);
    }

    @Override
    public int insertSelective(TblSpuType record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return spuTypeDao.insertSelective(record);
    }

    @Override
    public TblSpuType selectByPrimaryKey(String id) {
        return spuTypeDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpuType record) {
        TblSpuType spuType = getInfo(spuTypeDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, spuType);
        setObjectUpdateInfo(spuType, null);
        return spuTypeDao.updateByPrimaryKeySelective(spuType);
    }

    @Override
    public int updateByPrimaryKey(TblSpuType record) {
        TblSpuType spuType = getInfo(spuTypeDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, spuType);
        setObjectUpdateInfo(spuType, null);
        return spuTypeDao.updateByPrimaryKey(spuType);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(spuTypeDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpuType record) {
        getInfo(spuTypeDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return spuTypeDao.updateDelTag(record);
    }

    @Override
    public TblSpuType checkSpuType(String id) {
        TblSpuType spuType = this.selectByPrimaryKey(id);
        if(StringUtil.objIsEmpty(spuType)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_TYPE_NOT_FIND);
        }
        return spuType;
    }

    @Override
    public void checkDelTag(String id) {
        TblSpuType spuType = this.checkSpuType(id);
        if (!DelTagEnum.DEL_TAG_2.getCode().equals(spuType.getDelTag())) {
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_TYPE_INVALID);
        }
    }
}

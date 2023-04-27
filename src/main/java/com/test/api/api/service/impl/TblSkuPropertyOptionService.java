package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSkuPropertyOption;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSkuPropertyOptionDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblSkuPropertyOptionService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.commodity.skupropertyoption.SkuPropertyOptionVO;
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
 * @className TblSkuPropertyOptionService
 * @description TODO
 * @auther wangsheng
 * @creatTime 2021/12/19 下午5:48
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSkuPropertyOptionService implements ITblSkuPropertyOptionService {
    protected static final Logger logger = LoggerFactory.getLogger(TblSkuPropertyOptionService.class);

    @Autowired
    private TblSkuPropertyOptionDao skuPropertyOptionDao;
    @Autowired
    private ICommonService iCommonService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return skuPropertyOptionDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSkuPropertyOption record) {
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
        return skuPropertyOptionDao.insert(record);
    }

    @Override
    public int insertSelective(TblSkuPropertyOption record) {
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
        return skuPropertyOptionDao.insertSelective(record);
    }

    @Override
    public TblSkuPropertyOption selectByPrimaryKey(String id) {
        return skuPropertyOptionDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSkuPropertyOption record) {
        TblSkuPropertyOption skuPropertyOption = iCommonService.getInfo(skuPropertyOptionDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, skuPropertyOption);
        iCommonService.setObjectUpdateInfo(skuPropertyOption, null);
        return skuPropertyOptionDao.updateByPrimaryKeySelective(skuPropertyOption);
    }

    @Override
    public int updateByPrimaryKey(TblSkuPropertyOption record) {
        TblSkuPropertyOption skuPropertyOption = iCommonService.getInfo(skuPropertyOptionDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, skuPropertyOption);
        iCommonService.setObjectUpdateInfo(skuPropertyOption, null);
        return skuPropertyOptionDao.updateByPrimaryKey(skuPropertyOption);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(iCommonService.getPageInfo(skuPropertyOptionDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSkuPropertyOption record) {
        iCommonService.getInfo(skuPropertyOptionDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        iCommonService.setObjectUpdateInfo(record, null);
        return skuPropertyOptionDao.updateDelTag(record);
    }

    @Override
    public SkuPropertyOptionVO queryDetail(String id) {
        return skuPropertyOptionDao.queryDetail(id);
    }
}

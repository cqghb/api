package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSkuSpecificationOption;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSkuSpecificationOptionDao;
import com.test.api.api.service.ITblSkuSpecificationOptionService;
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
 * @className TblSkuSpecificationOptionService
 * @description 产品规格选项关联服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/19 下午5:57
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSkuSpecificationOptionService extends CommonService implements ITblSkuSpecificationOptionService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSkuSpecificationOptionService.class);

    @Autowired
    private TblSkuSpecificationOptionDao skuSpecificationOptionDao;


    @Override
    public int deleteByPrimaryKey(String id) {
        return skuSpecificationOptionDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSkuSpecificationOption record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return skuSpecificationOptionDao.insert(record);
    }

    @Override
    public int insertSelective(TblSkuSpecificationOption record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return skuSpecificationOptionDao.insertSelective(record);
    }

    @Override
    public TblSkuSpecificationOption selectByPrimaryKey(String id) {
        return skuSpecificationOptionDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSkuSpecificationOption record) {
        TblSkuSpecificationOption skuSpecificationOption = getInfo(skuSpecificationOptionDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, skuSpecificationOption);
        setObjectUpdateInfo(skuSpecificationOption, null);
        return skuSpecificationOptionDao.updateByPrimaryKeySelective(skuSpecificationOption);
    }

    @Override
    public int updateByPrimaryKey(TblSkuSpecificationOption record) {
        TblSkuSpecificationOption skuSpecificationOption = getInfo(skuSpecificationOptionDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, skuSpecificationOption);
        setObjectUpdateInfo(skuSpecificationOption, null);
        return skuSpecificationOptionDao.updateByPrimaryKey(skuSpecificationOption);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(skuSpecificationOptionDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSkuSpecificationOption record) {
        getInfo(skuSpecificationOptionDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return skuSpecificationOptionDao.updateDelTag(record);
    }
}

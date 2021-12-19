package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSku;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSkuDao;
import com.test.api.api.service.ITblSkuService;
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
 * @className TblSkuService
 * @description 产品服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/19 下午5:39
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSkuService extends CommonService implements ITblSkuService {
    protected static final Logger logger = LoggerFactory.getLogger(TblSkuService.class);

    @Autowired
    private TblSkuDao skuDao;


    @Override
    public int deleteByPrimaryKey(String id) {
        return skuDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSku record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return skuDao.insert(record);
    }

    @Override
    public int insertSelective(TblSku record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return skuDao.insertSelective(record);
    }

    @Override
    public TblSku selectByPrimaryKey(String id) {
        return skuDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSku record) {
        TblSku sku = getInfo(skuDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, sku);
        setObjectUpdateInfo(sku, null);
        return skuDao.updateByPrimaryKeySelective(sku);
    }

    @Override
    public int updateByPrimaryKey(TblSku record) {
        TblSku sku = getInfo(skuDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, sku);
        setObjectUpdateInfo(sku, null);
        return skuDao.updateByPrimaryKey(sku);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(skuDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSku record) {
        getInfo(skuDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return skuDao.updateDelTag(record);
    }
}

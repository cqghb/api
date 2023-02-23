package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSku;
import com.test.api.api.bean.TblSkuPropertyOption;
import com.test.api.api.bean.TblSkuSpecificationOption;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSkuDao;
import com.test.api.api.dto.commodity.sku.AddSkuDto;
import com.test.api.api.service.ITblSkuPropertyOptionService;
import com.test.api.api.service.ITblSkuService;
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
    @Autowired
    private ITblSkuSpecificationOptionService skuSpecificationOptionService;
    @Autowired
    private ITblSkuPropertyOptionService skuPropertyOptionService;


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
    public int insertSelective(AddSkuDto addSkuDto) {
        /**
         * 1. 检查产品编码是否重复
         * 2. 检查归属货品是否有效
         * 3. 检查属性是否有效
         * 4. 检查规格是否有效
         */
        TblSku record = new TblSku();
        BeanUtils.copyProperties(addSkuDto, record);
        String skuId = StringUtil.uuid();
        record.setId(skuId);
        setObjectInsertInfo(record, null);
        int i = skuDao.insertSelective(record);
        /* 设置SKU与规格组的关系 */
        for (String item : addSkuDto.getSpecOptiIdArr()) {
            TblSkuSpecificationOption sso = new TblSkuSpecificationOption();
            sso.setSkuId(skuId);
            sso.setSpecOptiId(item);
            skuSpecificationOptionService.insertSelective(sso);
        }
        /* 设置SKU与属性(SKU特有属性)的关系 */
        for (String item : addSkuDto.getProOptId()) {
            TblSkuPropertyOption spo = new TblSkuPropertyOption();
            spo.setSkuId(skuId);
            spo.setProOptId(item);
            skuPropertyOptionService.insertSelective(spo);
        }
        return i;
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

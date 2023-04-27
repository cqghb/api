package com.test.api.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.api.api.bean.TblSkuSpecificationOption;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSkuSpecificationOptionExtendsDao;
import com.test.api.api.service.ICommonService;
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
public class TblSkuSpecificationOptionService extends ServiceImpl<TblSkuSpecificationOptionExtendsDao,TblSkuSpecificationOption> implements ITblSkuSpecificationOptionService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSkuSpecificationOptionService.class);

    @Autowired
    private TblSkuSpecificationOptionExtendsDao skuSpecificationOptionExtendsDao;
    @Autowired
    private ICommonService iCommonService;


    @Override
    public int deleteByPrimaryKey(String id) {
        return skuSpecificationOptionExtendsDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSkuSpecificationOption record) {
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
//        return skuSpecificationOptionExtendsDao.insert(record);
        return 0;
    }

    @Override
    public int insertSelective(TblSkuSpecificationOption record) {
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
//        return skuSpecificationOptionExtendsDao.insertSelective(record);
        return 0;
    }

    @Override
    public TblSkuSpecificationOption selectByPrimaryKey(String id) {
//        return skuSpecificationOptionExtendsDao.selectByPrimaryKey(id);
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TblSkuSpecificationOption record) {
        TblSkuSpecificationOption skuSpecificationOption = iCommonService.getInfo(skuSpecificationOptionExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, skuSpecificationOption);
        iCommonService.setObjectUpdateInfo(skuSpecificationOption, null);
//        return skuSpecificationOptionExtendsDao.updateByPrimaryKeySelective(skuSpecificationOption);
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TblSkuSpecificationOption record) {
        TblSkuSpecificationOption skuSpecificationOption = iCommonService.getInfo(skuSpecificationOptionExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, skuSpecificationOption);
        iCommonService.setObjectUpdateInfo(skuSpecificationOption, null);
//        return skuSpecificationOptionExtendsDao.updateByPrimaryKey(skuSpecificationOption);
        return 0;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(iCommonService.getPageInfo(skuSpecificationOptionExtendsDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSkuSpecificationOption record) {
        iCommonService.getInfo(skuSpecificationOptionExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        iCommonService.setObjectUpdateInfo(record, null);
//        return skuSpecificationOptionExtendsDao.updateDelTag(record);
        return 0;
    }
}

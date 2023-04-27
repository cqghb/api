package com.test.api.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.api.api.bean.TblSpecificationOption;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpecificationOptionExtendsDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblSpecificationOptionService;
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
 * @className TblSpecificationOptionService
 * @description 产品规格选项服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/16 下午11:43
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSpecificationOptionService extends ServiceImpl<TblSpecificationOptionExtendsDao,TblSpecificationOption> implements ITblSpecificationOptionService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSpecificationOptionService.class);

    @Autowired
    private TblSpecificationOptionExtendsDao tblSpecificationOptionExtendsDao;
    @Autowired
    private ICommonService iCommonService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tblSpecificationOptionExtendsDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSpecificationOption record) {
//        return tblSpecificationOptionExtendsDao.insert(record);
        return 0;
    }

    @Override
    public int insertSelective(TblSpecificationOption record) {
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
        return tblSpecificationOptionExtendsDao.insertSelective(record);
    }

    @Override
    public TblSpecificationOption selectByPrimaryKey(String id) {
        return tblSpecificationOptionExtendsDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpecificationOption record) {
        TblSpecificationOption specificationOption = iCommonService.getInfo(tblSpecificationOptionExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, specificationOption);
        iCommonService.setObjectUpdateInfo(specificationOption, null);
        return tblSpecificationOptionExtendsDao.updateByPrimaryKeySelective(specificationOption);
    }

    @Override
    public int updateByPrimaryKey(TblSpecificationOption record) {
        return tblSpecificationOptionExtendsDao.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(iCommonService.getPageInfo(tblSpecificationOptionExtendsDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpecificationOption record) {
        iCommonService.getInfo(tblSpecificationOptionExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        iCommonService.setObjectUpdateInfo(record, null);
//        return tblSpecificationOptionExtendsDao.updateDelTag(record);
        return 0;
    }
}

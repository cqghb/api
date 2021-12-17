package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSpecification;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpecificationDao;
import com.test.api.api.service.ITblSpecificationService;
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
 * @className TblSpecificationService
 * @description 产品规格服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/16 上午12:28
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSpecificationService extends CommonService implements ITblSpecificationService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSpecificationService.class);

    @Autowired
    private TblSpecificationDao specificationDao;


    @Override
    public int deleteByPrimaryKey(String id) {
        return specificationDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSpecification record) {
        return specificationDao.insert(record);
    }

    @Override
    public int insertSelective(TblSpecification record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return specificationDao.insertSelective(record);
    }

    @Override
    public TblSpecification selectByPrimaryKey(String id) {
        return specificationDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpecification record) {
        TblSpecification specification = getInfo(specificationDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, specification);
        setObjectUpdateInfo(specification, null);
        return specificationDao.updateByPrimaryKeySelective(specification);
    }

    @Override
    public int updateByPrimaryKey(TblSpecification record) {
        return specificationDao.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(specificationDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpecification record) {
        getInfo(specificationDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return specificationDao.updateDelTag(record);
    }
}

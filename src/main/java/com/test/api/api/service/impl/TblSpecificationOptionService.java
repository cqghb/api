package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSpecificationOption;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpecificationOptionDao;
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
public class TblSpecificationOptionService extends CommonService implements ITblSpecificationOptionService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSpecificationOptionService.class);

    @Autowired
    private TblSpecificationOptionDao specificationOptionDao;


    @Override
    public int deleteByPrimaryKey(String id) {
        return specificationOptionDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSpecificationOption record) {
        return specificationOptionDao.insert(record);
    }

    @Override
    public int insertSelective(TblSpecificationOption record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return specificationOptionDao.insertSelective(record);
    }

    @Override
    public TblSpecificationOption selectByPrimaryKey(String id) {
        return specificationOptionDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpecificationOption record) {
        TblSpecificationOption specificationOption = getInfo(specificationOptionDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, specificationOption);
        setObjectUpdateInfo(specificationOption, null);
        return specificationOptionDao.updateByPrimaryKeySelective(specificationOption);
    }

    @Override
    public int updateByPrimaryKey(TblSpecificationOption record) {
        return specificationOptionDao.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(specificationOptionDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpecificationOption record) {
        getInfo(specificationOptionDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return specificationOptionDao.updateDelTag(record);
    }
}

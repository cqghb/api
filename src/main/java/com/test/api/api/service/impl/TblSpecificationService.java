package com.test.api.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.api.api.bean.TblSpecification;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpecificationExtendsDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblSpecificationGroupService;
import com.test.api.api.service.ITblSpecificationService;
import com.test.api.api.service.ITblSpuTypeService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.commodity.specification.SpecificationVO;
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
public class TblSpecificationService extends ServiceImpl<TblSpecificationExtendsDao, TblSpecification> implements ITblSpecificationService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSpecificationService.class);

    @Autowired
    private TblSpecificationExtendsDao tblSpecificationExtendsDao;

    @Autowired
    private ITblSpecificationGroupService specificationGroupService;

    @Autowired
    private ITblSpuTypeService spuTypeService;
    @Autowired
    private ICommonService iCommonService;


    @Override
    public int deleteByPrimaryKey(String id) {
        return tblSpecificationExtendsDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSpecification record) {
//        return tblSpecificationExtendsDao.insert(record);
        return 0;
    }

    @Override
    public int insertSelective(TblSpecification record) {
        /* 检查货品规格分组是否失效 */
//        specificationGroupService.checkDelTag(record.getGroupId());
        /* 检查货品规格类型是否失效 */
//        spuTypeService.checkDelTag(record.getTypeId());

        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
        return tblSpecificationExtendsDao.insertSelective(record);
    }

    @Override
    public TblSpecification selectByPrimaryKey(String id) {
        return tblSpecificationExtendsDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpecification record) {
        /* 检查货品规格分组是否失效 */
//        specificationGroupService.checkDelTag(record.getGroupId());
        /* 检查货品规格类型是否失效 */
//        spuTypeService.checkDelTag(record.getTypeId());

        TblSpecification specification = iCommonService.getInfo(tblSpecificationExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, specification);
        iCommonService.setObjectUpdateInfo(specification, null);
        return tblSpecificationExtendsDao.updateByPrimaryKeySelective(specification);
    }

    @Override
    public int updateByPrimaryKey(TblSpecification record) {
        return tblSpecificationExtendsDao.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(iCommonService.getPageInfo(tblSpecificationExtendsDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpecification record) {
        iCommonService.getInfo(tblSpecificationExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        iCommonService.setObjectUpdateInfo(record, null);
//        return tblSpecificationExtendsDao.updateDelTag(record);
        return 0;
    }

    @Override
    public SpecificationVO queryDetail(String id) {
        if (StringUtil.objIsEmpty(id)) {
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.ID_IS_NOT_NULL);
        }
//        return tblSpecificationExtendsDao.queryDetail(id);
        return null;
    }
}

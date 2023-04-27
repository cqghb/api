package com.test.api.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.api.api.bean.*;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSkuExtendsDao;
import com.test.api.api.dto.commodity.aftersales.TblSkuAfterSalesAddDto;
import com.test.api.api.dto.commodity.property.AddTblPropertyDto;
import com.test.api.api.dto.commodity.sku.AddSkuDto;
import com.test.api.api.dto.commodity.skuimage.TblImageAddDto;
import com.test.api.api.dto.commodity.specification.TblSpecificationAddDto;
import com.test.api.api.dto.commodity.specificationoption.TblSpecificationOptionAddDto;
import com.test.api.api.service.*;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

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
public class TblSkuService extends ServiceImpl<TblSkuExtendsDao, TblSku> implements ITblSkuService {
    protected static final Logger logger = LoggerFactory.getLogger(TblSkuService.class);

    @Autowired
    private TblSkuExtendsDao skuExtendsDao;
    @Autowired
    private ITblSkuAfterSalesService tblSkuAfterSalesService;
    @Autowired
    private ITblPropertyService tblPropertyService;
    @Autowired
    private ITblSpecificationService tblSpecificationService;
    @Autowired
    private ITblSpecificationOptionService specificationOptionService;
    @Autowired
    private ITblImageService tblImageService;
    @Autowired
    private ICommonService iCommonService;


    @Override
    public int deleteByPrimaryKey(String id) {
        return skuExtendsDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSku record) {
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
        save(record);
        return 1;
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
        iCommonService.setObjectInsertInfo(record, null);
        int i = skuExtendsDao.insertSelective(record);
        /* 设置SKU与规格组的关系 */
//        for (String item : addSkuDto.getSpecOptiIdArr()) {
//            TblSkuSpecificationOption sso = new TblSkuSpecificationOption();
//            sso.setSkuId(skuId);
//            sso.setSpecOptiId(item);
//            skuSpecificationOptionService.insertSelective(sso);
//        }
        /* 设置SKU与属性(SKU特有属性)的关系 */
//        for (String item : addSkuDto.getProOptId()) {
//            TblSkuPropertyOption spo = new TblSkuPropertyOption();
//            spo.setSkuId(skuId);
//            spo.setProOptId(item);
//            skuPropertyOptionService.insertSelective(spo);
//        }
        return i;
    }

    @Override
    public TblSku selectByPrimaryKey(String id) {
        return skuExtendsDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSku record) {
        TblSku sku = iCommonService.getInfo(skuExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, sku);
        iCommonService.setObjectUpdateInfo(sku, null);
        return skuExtendsDao.updateByPrimaryKeySelective(sku);
    }

    @Override
    public int updateByPrimaryKey(TblSku record) {
        TblSku sku = iCommonService.getInfo(skuExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, sku);
        iCommonService.setObjectUpdateInfo(sku, null);
        return skuExtendsDao.updateByPrimaryKey(sku);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(iCommonService.getPageInfo(skuExtendsDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSku record) {
        iCommonService.getInfo(skuExtendsDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        iCommonService.setObjectUpdateInfo(record, null);
//        return skuExtendsDao.updateDelTag(record);
        return 0;
    }

    @Override
    @Transactional
    public boolean addSku(AddSkuDto addSkuDto) {
        try {
            /* 保存产品信息 */
            TblSku sku = new TblSku();
            BeanUtils.copyProperties(addSkuDto, sku);
            String skuId = StringUtil.uuid();
            String no = StringUtil.getNo();
            // 检查skuId、number是否重复
            QueryWrapper<TblSku> wrapper = new QueryWrapper();
            wrapper.lambda().eq(TblSku::getId, skuId).eq(TblSku::getNo, no);
            List<TblSku> skuList = list(wrapper);
            if (!CollectionUtils.isEmpty(skuList)) {
                throw new AppException(MsgCodeConstant.ERROR_CODE, "产品主键或产品编号重复，请重试!");
            }
            /* 产品数量必须大于1 */
            int skuNumber = addSkuDto.getNumber();
            if (skuNumber < 1) {
                throw new AppException(MsgCodeConstant.ERROR_CODE, "产品数量必须大于1!");
            }
            /* 产品价格必须大于0.01 */
            BigDecimal price = addSkuDto.getPrice();
            /**
             * A.compareTo(B)
             * -1 A < B
             * 0  A = B
             * 1  A > B
             */
            int result = price.compareTo(new BigDecimal("0.01"));
            if (-1 == result) {
                throw new AppException(MsgCodeConstant.ERROR_CODE, "产品价格必须大于0.01!");
            }
            sku.setId(skuId);
            sku.setNo(no);
            sku.setVersion(CommConstant.PRO_VERSION);
            /* 设置基本信息 */
            iCommonService.setObjectInsertInfo(sku, null);
            /* 保存产品信息 */
            save(sku);
            /* 保存产品基本属性 */
            List<AddTblPropertyDto> basePropertyDtoList = addSkuDto.getDomains();
            for (AddTblPropertyDto propertyDto : basePropertyDtoList) {
                TblProperty tblProperty = new TblProperty();
                BeanUtils.copyProperties(propertyDto, tblProperty);
                String id = StringUtil.uuid();
                /* 设置ID */
                tblProperty.setId(id);
                /* 关联产品编号 */
                tblProperty.setSkuNo(no);
                /* 设置基本信息 */
                iCommonService.setObjectInsertInfo(tblProperty, null);
                /* 保存属性 */
                tblPropertyService.save(tblProperty);
            }
            /* 保存商品规格组 */
            List<TblSpecificationAddDto> specificationAddDtoList = addSkuDto.getSpecificationPackage();
            for (TblSpecificationAddDto specificationAddDto : specificationAddDtoList) {
                TblSpecification tblSpecification = new TblSpecification();
                BeanUtils.copyProperties(specificationAddDto, tblSpecification);
                String id = StringUtil.uuid();
                /* 设置ID */
                tblSpecification.setId(id);
                /* 关联产品编号 */
                tblSpecification.setSkuNo(no);
                /* 设置基本信息 */
                iCommonService.setObjectInsertInfo(tblSpecification, null);
                tblSpecificationService.save(tblSpecification);
                /* 保存规格组零部件 */
                List<TblSpecificationOptionAddDto> componentArrList = specificationAddDto.getComponentArr();
                for (TblSpecificationOptionAddDto tblSpecificationOptionAddDto : componentArrList) {
                    TblSpecificationOption specificationOption = new TblSpecificationOption();
                    BeanUtils.copyProperties(tblSpecificationOptionAddDto, specificationOption);
                    String specificationOptionId = StringUtil.uuid();
                    /* 设置ID */
                    specificationOption.setId(specificationOptionId);
                    /* 关联规格组ID */
                    specificationOption.setSpecId(id);
                    /* 设置基本信息 */
                    iCommonService.setObjectInsertInfo(specificationOption, null);
                    specificationOptionService.save(specificationOption);
                }
            }
            /* 保存产品售后说明 */
            TblSkuAfterSalesAddDto skuAfterSalesDto = addSkuDto.getSkuAfterSales();
            TblSkuAfterSales afterSales = new TblSkuAfterSales();
            BeanUtils.copyProperties(skuAfterSalesDto, afterSales);
            String afterSalesId = StringUtil.uuid();
            /* 设置ID */
            afterSales.setId(afterSalesId);
            /* 关联产品编号 */
            afterSales.setSkuNo(no);
            /* 设置基本信息 */
            iCommonService.setObjectInsertInfo(afterSales, null);
            tblSkuAfterSalesService.save(afterSales);
            /* 保存产品图像信息 */
            List<TblImageAddDto> imageAddDtoList = addSkuDto.getImageAddDtoList();
            for (TblImageAddDto imageAddDto : imageAddDtoList) {
                TblImage image = new TblImage();
                BeanUtils.copyProperties(imageAddDto, image);
                String imageId = StringUtil.uuid();
                /* 设置ID */
                image.setId(imageId);
                /* 关联产品编号 */
                image.setSkuNo(no);
                /* 设置基本信息 */
                iCommonService.setObjectInsertInfo(image, null);
                tblImageService.save(image);
            }
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }

    }
}

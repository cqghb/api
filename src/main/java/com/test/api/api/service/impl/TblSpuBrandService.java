package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSpuBrand;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpuBrandDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblSpuBrandService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblSpuBrandService
 * @description 商品品牌服务层实现类
 * @auther wangsheng
 * @creatTime 2021/12/14 上午12:35
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSpuBrandService implements ITblSpuBrandService {

    @Autowired
    private TblSpuBrandDao spuBrandDao;
    @Autowired
    private ICommonService iCommonService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return spuBrandDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSpuBrand record) {
        return spuBrandDao.insert(record);
    }

    @Override
    public int insertSelective(TblSpuBrand record) throws AppException {
        /**
         * 添加校验
         * 品牌编码和品牌名称不能重复
         */
        TblSpuBrand oldSpuBrand = spuBrandDao.queryOne(record);
        checkCodeName(oldSpuBrand, record);
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
        return spuBrandDao.insertSelective(record);
    }

    @Override
    public TblSpuBrand selectByPrimaryKey(String id) {
        return spuBrandDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpuBrand record) {
        TblSpuBrand oldSpuBrand = iCommonService.getInfo(spuBrandDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        TblSpuBrand oldSpuBrand2 = spuBrandDao.queryOne(record);
        checkCodeName(oldSpuBrand2, record);
        BeanUtils.copyProperties(record, oldSpuBrand);
        iCommonService.setObjectUpdateInfo(oldSpuBrand, null);
        return spuBrandDao.updateByPrimaryKeySelective(oldSpuBrand);
    }

    @Override
    public int updateByPrimaryKey(TblSpuBrand record) {
        return spuBrandDao.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(iCommonService.getPageInfo(spuBrandDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpuBrand record) throws AppException {
        TblSpuBrand tab = iCommonService.getInfo(spuBrandDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        iCommonService.setObjectUpdateInfo(record, null);
        return spuBrandDao.updateDelTag(record);
    }

    @Override
    public TblSpuBrand checkSpuBrand(String id) {
        TblSpuBrand spuBrand = this.selectByPrimaryKey(id);
        if(StringUtil.objIsEmpty(spuBrand)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_BRAND_NOT_FIND);
        }
        return spuBrand;
    }

    @Override
    public void checkSpuBrandDelTag(String id) {
        TblSpuBrand spuType = this.checkSpuBrand(id);
        if (!DelTagEnum.DEL_TAG_2.getCode().equals(spuType.getDelTag())) {
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_BRAND_INVALID);
        }
    }

    @Override
    public List<Map<String, String>> searchSpuBrand(TblSpuBrand spuBrand) {
        return spuBrandDao.searchSpuBrand(spuBrand);
    }

    /**
     * 检查SPU品牌编码、品牌名称是否重复
     * @param oldSpuBrand 存量
     * @param record 当前
     * @throws AppException
     */
    private void checkCodeName(TblSpuBrand oldSpuBrand, TblSpuBrand record) throws AppException {
        /**
         * 添加校验
         * 品牌编码和品牌名称不能重复
         */
        if(StringUtil.objIsEmpty(oldSpuBrand)){
            return ;
        }
        if(record.getCode().equals(oldSpuBrand.getCode())){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_BRAND_CODE_REPEAT);
        }
        if(record.getName().equals(oldSpuBrand.getName())){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_BRAND_NAME_REPEAT);
        }
    }
}

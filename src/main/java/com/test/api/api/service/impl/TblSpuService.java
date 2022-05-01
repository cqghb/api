package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSpu;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpuDao;
import com.test.api.api.service.ITblSpuService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.commodity.spu.ListSpuVO;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblSpuService
 * @description 货品服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/15 下午11:29
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSpuService extends CommonService implements ITblSpuService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSpuService.class);

    @Autowired
    private TblSpuDao spuDao;

    @Autowired
    private TblSpuTypeService spuTypeService;

    @Autowired
    private TblSpuBrandService spuBrandService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return spuDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSpu record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return spuDao.insert(record);
    }

    @Override
    public int insertSelective(TblSpu record) {
        /**
         * 1. 货品编码不能重复[检查是否有货品编码重复的]
         * 2. 检查货品类型是否存在
         * 3. 检查品牌是否存在
         */
        String code = record.getCode();
        String typeId = record.getTypeId();
        String brandId = record.getBrandId();
        /* 1.货品编码不能重复[检查是否有货品编码重复的] */
        spuCodeRepeat(code);
        /* 2. 检查货品类型是否存在 */
        spuTypeService.checkDelTag(typeId);
        /* 3. 检查品牌是否存在 */
        spuBrandService.checkSpuBrandDelTag(brandId);
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return spuDao.insertSelective(record);
    }

    @Override
    public TblSpu selectByPrimaryKey(String id) {
        return spuDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpu record) {
        /**
         * 1. 检查货品类型是否存在
         * 2. 检查品牌是否存在
         */
        String typeId = record.getTypeId();
        String brandId = record.getBrandId();
        /* 1. 检查货品类型是否存在 */
        spuTypeService.checkDelTag(typeId);
        /* 2. 检查品牌是否存在 */
        spuBrandService.checkSpuBrandDelTag(brandId);
        /* getInfo会检查货品师傅存在 */
        TblSpu spu = getInfo(spuDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, spu);
        setObjectUpdateInfo(spu, null);
        return spuDao.updateByPrimaryKeySelective(spu);
    }

    @Override
    public int updateByPrimaryKey(TblSpu record) {
        TblSpu spu = getInfo(spuDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, spu);
        setObjectUpdateInfo(spu, null);
        return spuDao.updateByPrimaryKey(spu);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(spuDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpu record) {
        getInfo(spuDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return spuDao.updateDelTag(record);
    }

    @Override
    public ListSpuVO selectDetail(String id) {
        return spuDao.selectDetail(id);
    }

    @Override
    public void spuCodeRepeat(String code) throws AppException {
        TblSpu param = new TblSpu();
        param.setCode(code);
        List<TblSpu> list = spuDao.searchList(param);
        if(StringUtil.objIsNotEmpty(list)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_CODE_REPEAT);
        }
    }

    @Override
    public TblSpu queryByCode(String code) {
        return spuDao.queryByCode(code);
    }


}

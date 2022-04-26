package com.test.api.api.service.impl;

import com.test.api.api.bean.TblSpuType;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblSpuTypeDao;
import com.test.api.api.service.ITblSpuTypeService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblSpuTypeService
 * @description 货品类型服务实现类
 * @auther wangsheng
 * @creatTime 2021/12/15 下午11:17
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblSpuTypeService extends CommonService implements ITblSpuTypeService {

    protected static final Logger logger = LoggerFactory.getLogger(TblSpuTypeService.class);

    @Autowired
    private TblSpuTypeDao spuTypeDao;


    @Override
    public int deleteByPrimaryKey(String id) {
        return spuTypeDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblSpuType record) {
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return spuTypeDao.insert(record);
    }

    @Override
    public int insertSelective(TblSpuType record) {
        this.checkSpuType(record);
        record.setId(StringUtil.uuid());
        setObjectInsertInfo(record, null);
        return spuTypeDao.insertSelective(record);
    }

    @Override
    public TblSpuType selectByPrimaryKey(String id) {
        return spuTypeDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TblSpuType record) {
        TblSpuType spuType = getInfo(spuTypeDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        this.checkSpuType(record);
        BeanUtils.copyProperties(record, spuType);
        setObjectUpdateInfo(spuType, null);
        return spuTypeDao.updateByPrimaryKeySelective(spuType);
    }

    @Override
    public int updateByPrimaryKey(TblSpuType record) {
        TblSpuType spuType = getInfo(spuTypeDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, spuType);
        setObjectUpdateInfo(spuType, null);
        return spuTypeDao.updateByPrimaryKey(spuType);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(spuTypeDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblSpuType record) {
        getInfo(spuTypeDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        setObjectUpdateInfo(record, null);
        return spuTypeDao.updateDelTag(record);
    }

    @Override
    public TblSpuType checkSpuType(String id) {
        TblSpuType spuType = this.selectByPrimaryKey(id);
        if(StringUtil.objIsEmpty(spuType)){
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_TYPE_NOT_FIND);
        }
        return spuType;
    }

    @Override
    public void checkDelTag(String id) {
        TblSpuType spuType = this.checkSpuType(id);
        if (!DelTagEnum.DEL_TAG_2.getCode().equals(spuType.getDelTag())) {
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.SPU_TYPE_INVALID);
        }
    }

    @Override
    public void checkSpuType(TblSpuType record) {
        List<TblSpuType> list = this.query(record);
        if(!StringUtil.objIsEmpty(list)){
            String errorMsg = "";
            String id = record.getId();
            String name = record.getName();
            String code = record.getCode();
            /* 虽然是循环，单正常情况下只有一条数据 */
            for(TblSpuType item : list){
                String oldId = item.getId();
                String oldName = item.getName();
                String oldCode = item.getCode();
                if(!id.equals(oldId)){/* 兼容维护的时候验证 */
                    if(oldName.equals(name)){
                        errorMsg += "货品类型名称: '"+name+ "' 重复;\n";
                    }
                    if(oldCode.equals(code)){
                        errorMsg += "货品类型代码: '"+code+ "' 重复;\n";
                    }
                }

            }
            if(!StringUtil.objIsEmpty(errorMsg)){
                throw new AppException(MsgCodeConstant.ERROR_CODE, errorMsg);
            }
        }
    }

    @Override
    public List<TblSpuType> query(TblSpuType record) {
        return spuTypeDao.query(record);
    }

    @Override
    public List<Map<String, String>> searchSPUTypeCode(TblSpuType record) {
        return spuTypeDao.searchSPUTypeCode(record);
    }
}

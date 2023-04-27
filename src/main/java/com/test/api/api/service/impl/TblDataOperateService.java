package com.test.api.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblDataOperate;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblDataOperateDao;
import com.test.api.api.service.ICommonService;
import com.test.api.api.service.ITblDataOperateService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.utils.StringUtil;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblDataOperateService
 * @description 数据操作服务实现类
 * @auther wangsheng
 * @creatTime 2021/9/29 2:02 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblDataOperateService implements ITblDataOperateService {

    @Autowired
    private TblDataOperateDao dataOperateDao;
    @Autowired
    private ICommonService iCommonService;


    @Override
    public int deleteByPrimaryKey(String id) {
        return dataOperateDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TblDataOperate record) {
        return dataOperateDao.insert(record);
    }

    @Override
    public int insertSelective(TblDataOperate record) {
        record.setId(StringUtil.uuid());
        iCommonService.setObjectInsertInfo(record, null);
        return dataOperateDao.insertSelective(record);
    }

    @Override
    public TblDataOperate selectByPKDelTag(String id, String delTag) {
        return dataOperateDao.selectByPKDelTag(id, delTag);
    }

    @Override
    public int updateByPrimaryKeySelective(TblDataOperate record) throws AppException {
        TblDataOperate dataOperate = iCommonService.getInfo(dataOperateDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        BeanUtils.copyProperties(record, dataOperate);
        iCommonService.setObjectUpdateInfo(dataOperate, null);
        return dataOperateDao.updateByPrimaryKeySelective(dataOperate);
    }

    @Override
    public int updateByPrimaryKey(TblDataOperate record) {
        return dataOperateDao.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(iCommonService.getPageInfo(dataOperateDao, CommConstant.QUERY_LIST, pageRequest));
    }

    @Override
    public int updateDelTag(TblDataOperate record) throws AppException {
        iCommonService.getInfo(dataOperateDao, CommConstant.SELECT_BY_PRIMARY_KEY, record.getId());
        record.setDelTag(DelTagEnum.DEL_TAG_1.getCode());
        iCommonService.setObjectUpdateInfo(record, null);
        return dataOperateDao.updateDelTag(record);
    }

    @Override
    public List<TblDataOperate> queryList(JSONObject record) {
        return dataOperateDao.queryList(record);
    }
}

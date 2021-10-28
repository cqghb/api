package com.test.api.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.test.api.api.bean.TblDataOperate;
import com.test.api.api.bo.CodeValueBO;
import com.test.api.api.config.AppException;
import com.test.api.api.constant.CommConstant;
import com.test.api.api.constant.ErrorMsgConstant;
import com.test.api.api.constant.MsgCodeConstant;
import com.test.api.api.constant.TableColumnEnum.DelTagEnum;
import com.test.api.api.dao.TblCodeValueDao;
import com.test.api.api.service.ITblCodeValueService;
import com.test.api.api.service.ITblDataOperateService;
import com.test.api.api.utils.PageUtils;
import com.test.api.api.vo.CodeValueVO;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @projectName api
 * @package com.test.api.api.service.impl
 * @className TblCodeValueService
 * @description 码值服务实现类
 * @auther wangsheng
 * @creatTime 2021/5/10 12:30 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
@Service
public class TblCodeValueService extends CommonService implements ITblCodeValueService {

    protected static Logger logger = LoggerFactory.getLogger(TblCodeValueService.class);

    @Autowired
    private TblCodeValueDao tblCodeValueDao;

    @Autowired
    private ITblDataOperateService dataOperateService;

    @Override
    public List<Map<String, String>> searchCodeKeyValue(CodeValueBO codeValueBO) {
        if(StringUtils.isEmpty(codeValueBO.getCodeType())){
            logger.error(ErrorMsgConstant.CODE_TYPE_NOT_NULL);
            throw new AppException(MsgCodeConstant.ERROR_CODE, ErrorMsgConstant.CODE_TYPE_NOT_NULL);
        }
        return tblCodeValueDao.searchCodeKeyValue(codeValueBO);
    }

    @Override
    public PageResult findPageChildren(PageRequest pageQuery) {
        PageInfo<CodeValueVO> codeValuePageInfoList = (PageInfo<CodeValueVO>) getPageInfo(tblCodeValueDao, CommConstant.QUERY_DATA_OPERATE_SUBGROUP,
                pageQuery);
        List<CodeValueVO> dataOperateGroup = codeValuePageInfoList.getList();
        this.getDataOperateList(dataOperateGroup, pageQuery);
        codeValuePageInfoList.setList(dataOperateGroup);
        return PageUtils.getPageResult(codeValuePageInfoList);
    }

    @Override
    public List<CodeValueVO> findPageChildren() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CommConstant.DEL_TAG, DelTagEnum.DEL_TAG_2.getCode());
        jsonObject.put("codeType", "dataOperateSubgroup");
        List<CodeValueVO> list = tblCodeValueDao.queryDataOperateSubgroup(jsonObject);
        getDataOperateList2(list);
        return list;
    }

    /**
     * 根据分组查询操作权限
     *
     * @param dataOperateGroup
     */
    private void getDataOperateList(List<CodeValueVO> dataOperateGroup, PageRequest pageQuery) {
        for (CodeValueVO item : dataOperateGroup) {
            String subgroup = item.getId();
            JSONObject jsonObject = (JSONObject) JSON.toJSON(pageQuery.getParams());
            jsonObject.put(CommConstant.SUBGROUP, subgroup);
            jsonObject.put(CommConstant.DEL_TAG, DelTagEnum.DEL_TAG_2.getCode());
            List<TblDataOperate> list = dataOperateService.queryList(jsonObject);
            item.setChildrenList(list);
        }
    }
    /**
     * 根据分组查询操作权限
     *
     * @param dataOperateGroup
     */
    private void getDataOperateList2(List<CodeValueVO> dataOperateGroup) {
        for (CodeValueVO item : dataOperateGroup) {
            String subgroup = item.getId();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(CommConstant.SUBGROUP, subgroup);
            jsonObject.put(CommConstant.DEL_TAG, DelTagEnum.DEL_TAG_2.getCode());
            List<TblDataOperate> list = dataOperateService.queryList(jsonObject);
            item.setChildrenList(list);
        }
    }
}

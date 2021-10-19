package com.test.api.api.service;

import com.alibaba.fastjson.JSONObject;
import com.test.api.api.bean.TblDataOperate;
import com.test.api.api.config.AppException;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblDataOperateService
 * @description 数据操作服务接口
 * @auther wangsheng
 * @creatTime 2021/9/29 1:59 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblDataOperateService {

    int deleteByPrimaryKey(String id);

    int insert(TblDataOperate record);

    int insertSelective(TblDataOperate record);

    TblDataOperate selectByPrimaryKey(String id, String delTag);

    int updateByPrimaryKeySelective(TblDataOperate record) throws AppException;

    int updateByPrimaryKey(TblDataOperate record);

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 修改删除标志
     * @param record
     * @return
     */
    int updateDelTag(TblDataOperate record) throws AppException;

    /**
     * 列表查询
     * @param record
     * @return
     */
    List<TblDataOperate> queryList(JSONObject record);
}

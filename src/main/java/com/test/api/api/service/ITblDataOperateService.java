package com.test.api.api.service;

import com.test.api.api.bean.TblDataOperate;

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

    TblDataOperate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblDataOperate record);

    int updateByPrimaryKey(TblDataOperate record);
}

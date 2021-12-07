package com.test.api.api.service;

import com.test.api.api.bean.TblIcon;
import com.test.api.api.dto.iconmanager.TblIconAddDto;
import com.test.api.api.dto.iconmanager.TblIconUpdateDto;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblIconService
 * @description 图标管理服务接口
 * @auther wangsheng
 * @creatTime 2021/9/8 1:02 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblIconService {

    int deleteByPrimaryKey(String id);

    int insert(TblIcon record);

    int insertSelective(TblIconAddDto record);

    TblIcon selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblIconUpdateDto record);

    int updateByPrimaryKey(TblIcon record);

    /**
     * 分页查询
     * @param pageRequest 分页参数
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 查询所有图标
     * @return
     */
    List<TblIcon> queryAll();
}

package com.test.api.api.service;

import com.test.api.api.bean.TblSpu;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSpuService
 * @description 货品服务接口
 * @auther wangsheng
 * @creatTime 2021/12/15 下午11:29
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSpuService {

    int deleteByPrimaryKey(String id);

    int insert(TblSpu record);

    int insertSelective(TblSpu record);

    TblSpu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpu record);

    int updateByPrimaryKey(TblSpu record);

    /**
     * 分页查询
     * @param pageRequest 分页参数
     * @return
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 修改删除标志
     *
     * @param record 更新数据
     * @return
     */
    int updateDelTag(TblSpu record);
}

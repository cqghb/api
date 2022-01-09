package com.test.api.api.service;

import com.test.api.api.bean.TblSpuType;
import com.test.api.api.vo.page.PageRequest;
import com.test.api.api.vo.page.PageResult;

import java.util.List;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblSpuTypeService
 * @description 货品类型服务接口
 * @auther wangsheng
 * @creatTime 2021/12/15 下午11:17
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblSpuTypeService {

    int deleteByPrimaryKey(String id);

    int insert(TblSpuType record);

    int insertSelective(TblSpuType record);

    TblSpuType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblSpuType record);

    int updateByPrimaryKey(TblSpuType record);

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
    int updateDelTag(TblSpuType record);

    /**
     * 检查货品类型是否存在，如不存在则抛出异常
     *
     * @param id 货品类型主键
     */
    TblSpuType checkSpuType(String id);

    /**
     * 检查货品类型是否已经失效，如已经失效则抛出异常
     *
     * @param id 货品类型主键
     */
    void checkDelTag(String id);

    /**
     * 检查货品类型，数据存在就报错
     * @param record 检查条件
     */
    void checkSpuType(TblSpuType record);
//    /**
//     * 检查货品类型，数据不存在就报错
//     * @param record 检查条件
//     * @param msg 错误消息
//     */
//    void checkSpuType2(TblSpuType record, String msg);

    /**
     * 列表查询
     *
     * @param record 查询条件
     * @return
     */
    List<TblSpuType> query(TblSpuType record);
}

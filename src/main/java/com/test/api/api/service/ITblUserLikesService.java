package com.test.api.api.service;

import com.test.api.api.bean.TblUserLikes;

/**
 * @projectName api
 * @package com.test.api.api.service
 * @className ITblUserLikesService
 * @description 用户喜好服务接口
 * @auther wangsheng
 * @creatTime 2021/5/10 12:31 上午
 * @company 四川省万源市一生活智能科技有限公司
 * @department 小程序-微信小程序
 */
public interface ITblUserLikesService {

    /**
     * 删除
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增，没做费控判断
     * @param record 喜好
     * @return
     */
    int insert(TblUserLikes record);

    /**
     * 新增,做了费控判断
     * @param record 喜好
     * @return
     */
    int insertSelective(TblUserLikes record);

    /**
     * 通过主键查询一条喜好
     * @param id 主键
     * @return
     */
    TblUserLikes selectByPrimaryKey(String id);

    /**
     * 更新喜好数据，做了费控判断
     * @param record 喜好
     * @return
     */
    int updateByPrimaryKeySelective(TblUserLikes record);

    /**
     * 通过主键更新喜好信息，没做费控判断
     * @param record 喜好
     * @return
     */
    int updateByPrimaryKey(TblUserLikes record);
}

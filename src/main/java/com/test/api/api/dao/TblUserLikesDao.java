package com.test.api.api.dao;

import com.test.api.api.bean.TblUserLikes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblUserLikesDao {
    /**
     * 删除
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(@Param("id") String id);

    /**
     * 通过用户号删除爱好数据
     * @param userId 用户号
     * @return
     */
    int deleteByUserId(@Param("userId")String userId);

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
    TblUserLikes selectByPrimaryKey(@Param("id") String id);

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

    List<String> queryUserLikeIds(@Param("userId") String userId);
}
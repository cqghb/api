package com.test.api.api.dao;

import com.test.api.api.bean.TblUserLikes;
import org.springframework.stereotype.Repository;

@Repository
public interface TblUserLikesDao {
    int deleteByPrimaryKey(String id);

    int insert(TblUserLikes record);

    int insertSelective(TblUserLikes record);

    TblUserLikes selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblUserLikes record);

    int updateByPrimaryKey(TblUserLikes record);
}
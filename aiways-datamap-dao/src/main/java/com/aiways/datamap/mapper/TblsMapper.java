package com.aiways.datamap.mapper;

import com.aiways.datamap.entity.Tbls;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblsMapper {
    int deleteByPrimaryKey(Long tblId);

    int insert(Tbls record);

    int insertSelective(Tbls record);

    Tbls selectByPrimaryKey(Long tblId);

    int updateByPrimaryKeySelective(Tbls record);

    int updateByPrimaryKeyWithBLOBs(Tbls record);

    int updateByPrimaryKey(Tbls record);

    int findCount();
}
package com.aiways.datamap.service;

import com.aiways.datamap.mapper.TblsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TblsMapper tblsMapper;

    public String hello(){
        int count = tblsMapper.findCount();
        return "总表数为："+count;
    }
}

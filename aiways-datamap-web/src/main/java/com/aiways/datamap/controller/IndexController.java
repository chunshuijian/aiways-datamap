package com.aiways.datamap.controller;

import com.aiways.datamap.exception.entity.Result;
import com.aiways.datamap.exception.utils.ResultUtil;
import com.aiways.datamap.hdfs.HadoopClient;
import com.aiways.datamap.mapper.TblsMapper;
import com.aiways.datamap.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    TestService testService;

    @Autowired
    TblsMapper tblsMapper;

    @Autowired
    HadoopClient hadoopClient;

    @GetMapping("/test")
    public Integer getTest() {
        String string = "12";
        return null;
    }

    @GetMapping("/hello")
    public String hello(){
        return testService.hello();
    }

    @GetMapping("/getTopSizeTable")
    public List getTopSizeTable(){
        List<Map.Entry<String, Long>> topSizeTable = hadoopClient.getTopSizeTable();
        return topSizeTable;
    }

    @GetMapping("/getSizeForHiveDatabase")
    public Long getSizeForHiveDatabase(){
        Long sizeForHiveDatabase = hadoopClient.getSizeForHiveDatabase();
        return sizeForHiveDatabase;
    }

    @GetMapping("/getTableCount")
    public Result getTableCount(){
        return ResultUtil.getSuccess(tblsMapper.findCount());
    }
}

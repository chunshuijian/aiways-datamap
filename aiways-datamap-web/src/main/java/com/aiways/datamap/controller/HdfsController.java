package com.aiways.datamap.controller;

import com.aiways.datamap.exception.entity.Result;
import com.aiways.datamap.exception.utils.ResultUtil;
import com.aiways.datamap.hdfs.HadoopClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hdfs")
public class HdfsController {

    @Autowired
    HadoopClient hadoopClient;

    /**
     * 查询 top50 热门表   hive数据库为default
     * @return
     */
    @GetMapping("/getTopSizeTable")
    public Result getTopSizeTable(){
        List<Map.Entry<String, Long>> tableList = hadoopClient.getTopSizeTable();
        if(null!=tableList && tableList.size()>50){
            tableList = tableList.subList(0,49);
        }
        return ResultUtil.getSuccess(tableList);
    }

    /**
     * 查询hive数据库占用的存储空间   hive的default库
     * @return
     */
    @GetMapping("/getSizeForHiveDatabase")
    public Result getSizeForHiveDatabase(){
        Long size = hadoopClient.getSizeForHiveDatabase();
        return ResultUtil.getSuccess(size);
    }

}

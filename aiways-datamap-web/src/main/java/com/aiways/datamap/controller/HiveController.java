//package com.aiways.datamap.controller;
//
//import com.aiways.datamap.exception.entity.Result;
//import com.aiways.datamap.exception.utils.ResultUtil;
//import com.aiways.datamap.mapper.TblsMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("hive")
//public class HiveController {
//
//    @Autowired
//    @Qualifier("hiveDruidTemplate")
//    private JdbcTemplate hiveJdbcTemplate;
//
//    @Autowired
//    TblsMapper tblsMapper;
//
//    /**
//     * 获取表的个数
//     * @return
//     */
//    @GetMapping("/getTableCount")
//    public Result getTableCount(){
//        return ResultUtil.getSuccess(tblsMapper.findCount());
//    }
//
//
//
//
////    /**
////     *获取表的DDL语句
////     * @param tableName
////     * @return
////     */
////    @GetMapping("/getShowCreateTable")
////    public Result getShowCreateTable(String tableName){
////        String sql ="show create TABLE "+tableName;
////        List<String> list= hiveJdbcTemplate.queryForList(sql,String.class);
////        StringBuilder ddl =  new StringBuilder();
////        for(Map m:mapList){
////
////        }
////        return ResultUtil.getSuccess(list);
////    }
//
//}

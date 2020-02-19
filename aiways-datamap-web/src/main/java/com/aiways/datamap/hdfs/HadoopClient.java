package com.aiways.datamap.hdfs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.util.*;

/**
 * Hadoop 操作类
 */
@Slf4j
@Data
@AllArgsConstructor
public class HadoopClient {

    private FileSystem fs;
    private String hadoopDirectoryPath;//hive数据库在hdfs上的路径

    /**
     * 获取hive数据库总的占用存储空间
     */
    public Long getSizeForHiveDatabase(){
        Long size = null;
        try {
            size = fs.getContentSummary(new Path(hadoopDirectoryPath)).getLength();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    /**
     * 获取hive表占用数据库存储空间的top 50排行
     */
    public List<Map.Entry<String, Long>> getTopSizeTable() {
        Path remotePath = new Path(hadoopDirectoryPath);
        List<Map.Entry<String, Long>> list = new ArrayList<>();
        try {
            if (fs.exists(remotePath)) {
                FileStatus[] stats = fs.listStatus(remotePath);
                Map<String, Long> sizeTableMap = new HashMap<>(10000); //用于存储前50 top 表
                for (int i = 0; i < stats.length; ++i) {
                    String tableName;
                    System.out.println(stats[i].getPath().toString());
                    tableName = stats[i].getPath().toString();
                    long tableLength = fs.getContentSummary(stats[i].getPath()).getLength();
                    tableName = tableName.substring(tableName.lastIndexOf("/")+1);
                    sizeTableMap.put(tableName,tableLength);
                }
                // 升序比较器
                Comparator<Map.Entry<String, Long>> valueComparator = new Comparator<Map.Entry<String, Long>>() {
                    @Override
                    public int compare(Map.Entry<String, Long> o1,
                                       Map.Entry<String, Long> o2) {
                        // TODO Auto-generated method stub
                        return (int) (o2.getValue() - o1.getValue());
                    }
                };
                list = new ArrayList<Map.Entry<String,Long>>(sizeTableMap.entrySet());
                Collections.sort(list,valueComparator);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}

package com.aiways.datamap.config;

import com.aiways.datamap.hdfs.HadoopClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class HadoopConfig {

    @Value("${hadoop.nameNode}")
    private String hdfsPath;

    @Value("${hadoop.directoryPath}")
    private String hadoopDirectoryPath;

    /**
     * 配置
     */
    public org.apache.hadoop.conf.Configuration getConfiguration() {
        //读取配置文件
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("fs.defaultFS", hdfsPath);
        return conf;
    }

    @Bean
    public FileSystem fs(){
        // 文件系统
        FileSystem fs = null;
        try {
            fs = FileSystem.get(this.getConfiguration());
        } catch (Exception e) {
            log.error("【FileSystem配置初始化失败】", e);
        }
        return fs;
    }

    @Bean
    @ConditionalOnBean(FileSystem.class)
    public HadoopClient hadoopClient() {
        return new HadoopClient(fs(), hadoopDirectoryPath);
    }
}

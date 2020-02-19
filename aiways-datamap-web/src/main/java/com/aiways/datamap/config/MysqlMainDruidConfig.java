//package com.aiways.datamap.config;
//
//import javax.sql.DataSource;
//import lombok.Data;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.context.annotation.Primary;
//
//import java.sql.SQLException;
//import java.util.Properties;
//
///**
// * -配置mysql主数据源，mysql连接默认主数据源
// * @author wdd
// * @Date 2019年11月04日
// *
// */
//@Configuration
//@ConfigurationProperties(prefix = "spring.datasource.mysqlMain")
//@Data
//public class MysqlMainDruidConfig {
//
//    private static Logger logger = LoggerFactory.getLogger(MysqlMainDruidConfig.class);
//
//    private String url;
//    private String user;
//    private String password;
//    private String driverClassName;
//    private int initialSize;
//    private int minIdle;
//    private int maxActive;
//    private int maxWait;
//    private int timeBetweenEvictionRunsMillis;
//    private int minEvictableIdleTimeMillis;
//    private String validationQuery;
//    private boolean testWhileIdle;
//    private boolean testOnBorrow;
//    private boolean testOnReturn;
//    private boolean poolPreparedStatements;
//    private String filters;
//    private int maxPoolPreparedStatementPerConnectionSize;
//    private boolean useGlobalDataSourceStat;
//    private Properties connectionProperties;
//
//    @Primary //标明为主数据源，只能标识一个主数据源，mybatis连接默认主数据源
//    @Bean(name = "mysqlDruidDataSource")
//    @Qualifier("mysqlDruidDataSource")
//    public DataSource dataSource() {
//        logger.info("=============== init mysqlDruidDataSource ==========");
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(url);
//        datasource.setUsername(user);
//        datasource.setPassword(password);
//        datasource.setDriverClassName(driverClassName);
//        // pool configuration
//        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
//        datasource.setMaxActive(maxActive);
//        datasource.setMaxWait(maxWait);
//        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setValidationQuery(validationQuery);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        try {
//            datasource.setFilters(filters);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        datasource.setMaxPoolPreparedStatementPerConnectionSize(
//                maxPoolPreparedStatementPerConnectionSize);
//        datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
//        datasource.setConnectProperties(connectionProperties);
//        return datasource;
//    }
//
//}
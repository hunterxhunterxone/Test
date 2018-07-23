package com.zzz.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@MapperScan(basePackages="com.zzz.dao")
@SpringBootConfiguration
public class DataSourceConfiguration {
	@Value("${spring.datasource.driver-class-name}")
	private String jdbcDriver;
	 @Value("${spring.datasource.url}")
	 private String jdbcUrl;
	 @Value("${spring.datasource.username}")
	 private String jdbcUser;
	 @Value("${spring.datasource.password}")
	 private String jdbcPassword;
	 @Bean
	 public DataSource createDataSource() throws PropertyVetoException {
		 ComboPooledDataSource dataSource = new ComboPooledDataSource();
		 
		 dataSource.setDriverClass(jdbcDriver);
		 dataSource.setJdbcUrl(jdbcUrl);
		 dataSource.setUser(jdbcUser);
		 dataSource.setPassword(jdbcPassword);
		 dataSource.setAutoCommitOnClose(false);
		 
		 return dataSource;
	 }
}

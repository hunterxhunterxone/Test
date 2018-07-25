package com.zzz;




import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * spring-boot 启动类
 *
 */
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan(basePackages="com.zzz")
@MapperScan(basePackages="com.zzz.dao")
@ServletComponentScan(basePackages="com.zzz.listener")
public class Application {
	private static Logger logger = Logger.getLogger(Application.class);
	public static void main(String[] args) {
		logger.info("start..");
		SpringApplication.run(Application.class, args);
	}
}
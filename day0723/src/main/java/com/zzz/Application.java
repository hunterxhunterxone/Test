package com.zzz;

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
@ComponentScan("com.zzz")
@MapperScan("com.zzz.dao")
@ServletComponentScan(basePackages="com.zzz.listener")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
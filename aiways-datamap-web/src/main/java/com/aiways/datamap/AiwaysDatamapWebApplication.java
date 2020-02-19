package com.aiways.datamap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.aiways.platform.upm.sdk"})
@ServletComponentScan
@MapperScan("com.aiways.datamap")
@ComponentScan("com.aiways.datamap")
public class AiwaysDatamapWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiwaysDatamapWebApplication.class, args);
	}

}

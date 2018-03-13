package com.anu.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
//for jsr310 java 8 java.time.*
@EntityScan(
      basePackageClasses = {SpringBootMainApp.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
@ComponentScan("com.anu.springbootstarter")
public class SpringBootMainApp {

  public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApp.class, args);

	}

}

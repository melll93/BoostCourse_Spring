package kr.or.connect.daoExam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.connect.daoExam.dao" })
@Import({ DBConfig.class })
public class ApplicationConfig {

}

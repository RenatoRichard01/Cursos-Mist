package br.com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude= {HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages="br.com")
public class Main  extends SpringBootServletInitializer {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }
  
}
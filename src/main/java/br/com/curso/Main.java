package br.com.curso;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="br.com")
@EnableJpaRepositories(basePackages="br.com")
public class Main {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }
  
}
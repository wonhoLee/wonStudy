package me.springboot;

import me.springboot.configuration.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ComponentScan
//@Configuration
//@Import(ServiceConfig.class)
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

}

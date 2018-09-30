package me.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan
//@Configuration
//@Import(ServiceConfig.class)
//@ImportResource("application.xml")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

}

/*
application.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userService" class="me.springboot.user.UserService" />

</beans>
 */
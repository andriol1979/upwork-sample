package com.kbtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
//@ComponentScan(excludeFilters={@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value=MongoConfiguration.class)})
public class KbToolServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KbToolServiceApplication.class, args);
    }

}

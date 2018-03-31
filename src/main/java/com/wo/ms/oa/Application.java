package com.wo.ms.oa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wo.ms.oa.dao","com.wo.ms.oa.*"})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}

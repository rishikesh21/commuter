package com.is5126.nus.commuter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class CommuterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommuterApplication.class, args);
        GetDataController obj=new GetDataController();
        obj.getDataFiles();

    }
}

package com.example.spring;

import com.example.spring.service.interfaces.ShareServiceI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Application {


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}

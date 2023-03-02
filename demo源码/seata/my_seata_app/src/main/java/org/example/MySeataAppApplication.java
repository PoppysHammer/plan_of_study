package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "org.example.mapper")
public class MySeataAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySeataAppApplication.class, args);
    }
}

package com.github.dlism.traveldiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class TravelDiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelDiaryApplication.class, args);
    }

}

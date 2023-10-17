package com.ecole.gestionclasses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GestionClassesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionClassesApplication.class, args);
    }

}

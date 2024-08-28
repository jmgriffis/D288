package com.d288.jgriffis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class JgriffisApplication {

    public static void main(String[] args) {
        SpringApplication.run(JgriffisApplication.class, args);
    }

}

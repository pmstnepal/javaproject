package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author pmstn
 *
 */

@SpringBootApplication
@EnableEurekaClient
public class MainSpringBoot {
	public static void main(String[] args) {
		SpringApplication.run(MainSpringBoot.class, args);
	}

}

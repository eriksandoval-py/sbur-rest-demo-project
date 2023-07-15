package com.eriksandoval.sburrestdemoproject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SburRestDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoProjectApplication.class, args);
	}
}


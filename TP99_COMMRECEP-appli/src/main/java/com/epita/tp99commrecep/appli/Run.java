package com.epita.tp99commrecep.appli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Run {
	public static void main(String[] args){
		SpringApplication.run(Run.class, args);
	}

}

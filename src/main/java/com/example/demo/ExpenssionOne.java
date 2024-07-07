package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenssionOne {

	public static void main(String[] args) {
		var app = new SpringApplication(ExpenssionOne.class);
		var ctx = app.run(args);
		// DbService dbService = ctx.getBean(DbService.class);
		// dbService.insertDB();
	}

}

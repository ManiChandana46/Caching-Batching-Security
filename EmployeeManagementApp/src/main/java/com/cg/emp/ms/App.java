package com.cg.emp.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 
 * @author Vaman Deshmukh
 *
 */

@SpringBootApplication
@EnableCaching
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

}

// netstat -ano | findstr :<PORT>
// taskkill /PID <PID> /F 
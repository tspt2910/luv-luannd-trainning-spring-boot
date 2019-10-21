package com.jp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiApplication {
	
	/**
	 * Entry point for api trainning Application.
	 *
	 * @param args application arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		
	}
	
	/**
	 * Return application version.
	 *
	 * @return application version
	 */
	public static String getVersionString() {
		return "[WORKING]";
	}
}

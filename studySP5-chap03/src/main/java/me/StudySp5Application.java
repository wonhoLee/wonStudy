package me;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudySp5Application {
	
	private static final Logger log = LoggerFactory.getLogger(StudySp5Application.class);

	public static void main(String[] args) {
		SpringApplication.run(StudySp5Application.class, args);
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		
	}
}

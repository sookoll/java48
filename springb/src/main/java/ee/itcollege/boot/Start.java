package ee.itcollege.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start {

	public static void main(String[] args) {
		System.setProperty("server.port", "8080");
		SpringApplication.run(Start.class, args);
	}
	
}

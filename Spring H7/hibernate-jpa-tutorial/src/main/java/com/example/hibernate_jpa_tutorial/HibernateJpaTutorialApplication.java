package com.example.hibernate_jpa_tutorial;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching // Mengaktifkan caching
public class HibernateJpaTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaTutorialApplication.class, args);
	}

}

package com.wsaults.budget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BudgetApplication {

	private static final Logger log = LoggerFactory.getLogger(BudgetApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BudgetApplication.class, args);
	}

	// @Bean
	// UserRepository userRepository() {
	// 	return new InMemoryUserRepository();
	// }

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			// User
			userRepository.save(new User("Will"));
			userRepository.save(new User("Marci"));

			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			// Category
			categoryRepository.save(new Category("Fuel", 100.0f));
			categoryRepository.save(new Category("Food", 50.0f));

			log.info("Categories found with findAll():");
			log.info("-------------------------------");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			log.info("");
		};
	}
}


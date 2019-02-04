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

			// Category
			categoryRepository.save(new Category("Fuel", 0.0f, 240.0f));
			categoryRepository.save(new Category("Groceries", 0.0f, 400.0f));
			categoryRepository.save(new Category("Shopping", 0.0f, 50.0f));
			categoryRepository.save(new Category("Restaurant", 0.0f, 100.0f));
			categoryRepository.save(new Category("Health", 0.0f, 50.0f));
			categoryRepository.save(new Category("Vitamins", 0.0f, 200.0f));

			log.info("Categories found with findAll():");
			log.info("-------------------------------");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			log.info("");
		};
	}
}


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
			categoryRepository.save(new Category("Fuel", 25.0f, 100.0f, "fas fa-gas-pump"));
			categoryRepository.save(new Category("Groceries", 0.0f, 500.0f, "fas fa-utensils"));
			categoryRepository.save(new Category("Shopping", 0.0f, 50.0f, "fas fa-shopping-bag"));
			categoryRepository.save(new Category("Restaurant", 10.0f, 50.0f, "fas fa-cheeseburger"));
			categoryRepository.save(new Category("Health", 0.0f, 50.0f, "fas fa-briefcase-medical"));

			log.info("Categories found with findAll():");
			log.info("-------------------------------");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			log.info("");
		};
	}
}


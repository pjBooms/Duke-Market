package dukemarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This file created by Maxim S. Ivanov
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

package dukemarket;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This file created by Maxim S. Ivanov
 */
@Configuration
@EntityScan
@EnableJpaRepositories
public class DataConfiguration {
}

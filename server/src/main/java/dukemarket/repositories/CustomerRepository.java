package dukemarket.repositories;

import dukemarket.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This file created by Maxim S. Ivanov
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

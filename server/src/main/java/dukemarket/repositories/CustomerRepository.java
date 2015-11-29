package dukemarket.repositories;

import dukemarket.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This file created by Maxim S. Ivanov
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);

    Optional<Customer> findByKey(String key);
}

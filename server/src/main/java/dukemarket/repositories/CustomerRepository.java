package dukemarket.repositories;

import dukemarket.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * This file created by Maxim S. Ivanov
 */
@Component
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);

    Optional<Customer> findByKey(String key);
}

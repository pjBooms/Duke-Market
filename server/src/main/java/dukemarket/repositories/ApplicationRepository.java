package dukemarket.repositories;

import dukemarket.domain.DukeApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This file created by Maxim S. Ivanov
 */

@Component
public interface ApplicationRepository extends JpaRepository<DukeApplication, Long> {
    DukeApplication findByKey(String key);

    @Query("select app from DukeApplication app where app.customer.key = :customer")
    List<DukeApplication> findByCustomer(@Param("customer") String customer);
}

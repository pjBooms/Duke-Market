package dukemarket.repositories;

import dukemarket.domain.DukeApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This file created by Maxim S. Ivanov
 */

public interface ApplicationRepository extends JpaRepository<DukeApplication, Long> {
    DukeApplication findByKey(String key);

    @Query("select apps from DukeApplication app where app.customer.key = :customer")
    List<DukeApplication> findByCustomer(String customer);

}

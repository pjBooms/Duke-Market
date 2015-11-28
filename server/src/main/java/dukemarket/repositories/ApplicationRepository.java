package dukemarket.repositories;

import dukemarket.domain.DukeApplication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This file created by Maxim S. Ivanov
 */

public interface ApplicationRepository extends JpaRepository<DukeApplication, Long> {
}

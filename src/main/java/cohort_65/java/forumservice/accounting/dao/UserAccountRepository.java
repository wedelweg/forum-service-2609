package cohort_65.java.forumservice.accounting.dao;

import cohort_65.java.forumservice.accounting.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    Optional<UserAccount> findByLoginIgnoreCase(String login);
    boolean existsByLoginIgnoreCase(String login);
}

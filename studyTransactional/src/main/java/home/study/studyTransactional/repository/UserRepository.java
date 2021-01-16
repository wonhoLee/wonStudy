package home.study.studyTransactional.repository;

import home.study.studyTransactional.repository.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

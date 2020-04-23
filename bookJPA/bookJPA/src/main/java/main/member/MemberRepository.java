package main.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	@Transactional(readOnly = true)
	Member findById(String id);
}

package main.repository;

import main.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

//    @Query("select m from Member m where m.name = :name")
//    List<Member> findByName(@Param("name") String name);

    List<Member> findByName(String name);
}

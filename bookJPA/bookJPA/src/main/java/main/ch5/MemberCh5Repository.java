package main.ch5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberCh5Repository extends JpaRepository<MemberCh5, Integer> {

    @Query("SELECT m FROM MemberCh5 m join m.team t WHERE t.name=:teamName")
    @Transactional(readOnly = true)
    List<MemberCh5> findByTeamName(@Param("teamName") String teamName);
}

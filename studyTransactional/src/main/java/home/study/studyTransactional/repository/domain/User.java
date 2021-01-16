package home.study.studyTransactional.repository.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    private String loginId;
    private String userName;
    private String email;

    @Builder
    public User(String loginId, String userName, String email) {
        this.loginId = loginId;
        this.userName = userName;
        this.email = email;
    }
}

package home.study.studyTransactional.service;

import home.study.studyTransactional.repository.UserRepository;
import home.study.studyTransactional.repository.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long addUser(String loginId){
        User user = User.builder().
                loginId(loginId)
                .build();
        User saveUser = userRepository.save(user);
        return saveUser.getId();
    }

    public void putUserName(Long id, String userName){
        User user = userRepository.findById(id).orElse();
        user.setUserName(userName);
        userRepository.save(user);
    }
    
}

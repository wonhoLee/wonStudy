package me.won.effectivejava3rd.item03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserService2 {
	@Autowired
	UserRepository userRepository;
}

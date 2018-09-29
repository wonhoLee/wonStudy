package me.springboot;

import me.springboot.user.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    UserService userService;

    @Test
    public void di(){
        //ctrl + shift + f10
        Assert.assertNotNull(userService);
        //Assert.assertEquals(1, 0);
    }
}

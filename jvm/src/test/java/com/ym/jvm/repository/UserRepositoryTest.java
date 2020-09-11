package com.ym.jvm.repository;

import com.ym.jvm.dao.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insert(){
        userRepository.insert(new User(1,"yangming","man",99));
    }

    @Test
    public void find(){
        Optional<User> user = userRepository.findById(1);
        System.out.println(user.toString());
    }

    @Test
    public void test(){
        Optional<Integer> val = Optional.empty();

    }

}

package com.vuongtq.springdemo;

import com.vuongtq.springdemo.entity.CCCDEntity;
import com.vuongtq.springdemo.entity.FeedEntity;
import com.vuongtq.springdemo.entity.UserEntity;
import com.vuongtq.springdemo.repository.CCCDRepository;
import com.vuongtq.springdemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class UserCCCDTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CCCDRepository cccdRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void oneToOneTest() {
        UserEntity user = new UserEntity();
        CCCDEntity cccd = new CCCDEntity();

        user.setUserName("v-test-cccd");
        user.setUserEmail("v-test-cccd@gmail.com");

        cccd.setNumberCCCD("11112222");
        user.setCccd(cccd);

        userRepository.save(user);
    }
}

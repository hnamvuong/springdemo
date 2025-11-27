package com.vuongtq.springdemo;

import com.vuongtq.springdemo.entity.FeedEntity;
import com.vuongtq.springdemo.entity.UserEntity;
import com.vuongtq.springdemo.repository.FeedRepository;
import com.vuongtq.springdemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserFeedTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void oneToManyTest() {
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserName("v-test1");
        user.setUserEmail("v-test1@gmail.com");
        feed.setTitle("feed 2");

        List<FeedEntity> feeds = new ArrayList<>();
        feeds.add(feed);
        user.setFeedList(feeds);
        feed.setUser(user);

        userRepository.save(user);
        feedRepository.save(feed);
    }

    @Test
    @Transactional
    void selectOneToManyTest() {
        UserEntity user = userRepository.findById(11L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getFeedList());
    }
}

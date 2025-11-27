package com.vuongtq.springdemo.repository;

import com.vuongtq.springdemo.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<FeedEntity, Long> {
}

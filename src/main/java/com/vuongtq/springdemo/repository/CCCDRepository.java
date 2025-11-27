package com.vuongtq.springdemo.repository;

import com.vuongtq.springdemo.entity.CCCDEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CCCDRepository  extends JpaRepository<CCCDEntity, Long> {
}

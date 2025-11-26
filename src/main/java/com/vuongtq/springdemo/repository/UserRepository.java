package com.vuongtq.springdemo.repository;

import com.vuongtq.springdemo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    Page<UserEntity> findByUserName(String name, Pageable pageable);
}

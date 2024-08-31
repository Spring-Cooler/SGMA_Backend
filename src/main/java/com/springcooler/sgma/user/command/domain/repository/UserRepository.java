package com.springcooler.sgma.user.command.domain.repository;

import com.springcooler.sgma.user.command.domain.aggregate.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
}
